/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 6 <br />
 * Exercise: 18 <br />
 * Description: Check password meets all required conditions <br />
 * Due: 3/28/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

/*
6.18 
(Check password) Some websites impose certain rules for passwords. Write a
method that checks whether a string is a valid password. Suppose the password
rules are as follows:
* A password must have at least eight characters.
* A password consists of only letters and digits.
* A password must contain at least two digits.
Write a program that prompts the user to enter a password and displays Valid
Password if the rules are followed or Invalid Password otherwise.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class C6E18CheckPassword extends JPanel
					    implements ActionListener{
	private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;

    public C6E18CheckPassword(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        passwordField.setEchoChar((char)0); //Show password being entered

        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(passwordField);

        JComponent buttonPane = createButtonPanel();

        //Lay out everything.
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);

        add(textPane);
        add(buttonPane);
    }


    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("OK");
        JButton helpButton = new JButton("Help");

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }


    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String errorMessage = "";

        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            errorMessage = isPasswordCorrect(input);
            if (errorMessage == "Valid") {
                JOptionPane.showMessageDialog(controllingFrame,
                    "Success! You typed the right password.");
            } 
            else { //If returned string not "Valid" an error occurred
                JOptionPane.showMessageDialog(controllingFrame,
                    "Invalid password. "+errorMessage+". Try again.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            Arrays.fill(input, '0');

            passwordField.selectAll();
            resetFocus();
        } else { //The user has asked for help.
            JOptionPane.showMessageDialog(controllingFrame,
                "PASSWORD REQUIREMENTS:\n"
              + "\t1) A password must have at least 8 characters.\n"
              + "\t2) A password consists of only letters and digits.\n"
              + "\t3) A password must contain at least 2 digits.\n");
        }
    }

    /**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */

    private static String isPasswordCorrect(char[] input) {
        String newInput = new String(input);
        //String pattern = "^(?=.*?\\d.*\\d)[a-zA-Z0-9]{8,}$";
        

        if (!(newInput.length() >= 8)) {				//Rule 1: At least 8 characters
        	return "MUST be at least 8 characters long";
        } 
        if (!newInput.matches("^[\\w]+$")) {					// Rule 2: Only letters and #s
        	return "Can ONLY contain alpha-numeric characters";	// ^...$ --> from beginning to end of string
        }														// [\\w]+ --> check if character is alpha numeric
        
        if (!newInput.matches("^.*?\\d.*?\\d.*$")) {	// Rule 3: At least 2 digits
        	return "MUST containt at least 2 digits";	// ^...$ --> from beginning to end of string
        }												// .*? --> zero or more occurrences of any char : ? --> one time or not at all
        												// \\d.*?\\d at least 2 digits in the string
        												// .* --> zero or more characters after the #s
	    												// Negated to return true only when they are not present
        //Passing all rules returns "Valid"
        return "Valid";
    }

    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("C6E18CheckPassword");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final C6E18CheckPassword newContentPane = new C6E18CheckPassword(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }

}		



