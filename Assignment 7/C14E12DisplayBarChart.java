/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 14 <br />
 * Exercise: 12 <br />
 * Description: Display barchart of class grade percentages <br />
 * Due: 4/25/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
 14.12
(Display a bar chart) Write a program that uses a bar chart to display the percentages
of the overall grade represented by projects, quizzes, midterm exams, and the
final exam, as shown in Figure 14.46b. Suppose that projects take 20 percent and
are displayed in red, quizzes take 10 percent and are displayed in blue, midterm
exams take 30 percent and are displayed in green, and the final exam takes 40
percent and is displayed in orange. Use the Rectangle class to display the bars.
Interested readers may explore the JavaFX BarChart class for further study.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class C14E12DisplayBarChart extends Application {
	//Two panes, one for TextFields and one for Bar Chart which update 
	// when Update button is pressed
	private DataPane dataPane = new DataPane();
	private BarChart chartPane = new BarChart();
	
	@Override
	public void start(Stage primaryStage) {
		//Setting up main scene
		GridPane mainPane = new GridPane();
		Button btUpdate = new Button("Update");
		mainPane.add(btUpdate, 0, 1);
		GridPane.setHalignment(btUpdate, HPos.CENTER);
		
		//Create and Register the handler
		btUpdate.setOnAction(new UpdateHandlerClass());
		
		//Put Textfields and Barchart in the main pane
		mainPane.add(dataPane,0,0);
		mainPane.add(chartPane, 1, 0);
		
		//Set up scene and stage with the main pane
		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("Bar chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}// end void start

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//Class to deal with the Update button being pressed
	class UpdateHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if(dataPane.update() == true) //Clears the text feilds, checks if inputs were valid
			{
				dataPane.removeError(); //Clears any previous error messages
				chartPane.removeAll(); //Cleans the Bar Chart
				chartPane.update(dataPane.getData()); //Re draws the bar chart with new data from user
			}
		}
	}
	
	//Sub class to maintain the Text Fields for user input
	class DataPane extends GridPane { 
		private double [] data = {0, 0, 0, 0};
		
		private TextField projectTF = new TextField();
		private TextField quizTF = new TextField();
		private TextField midtermTF = new TextField();
		private TextField finalTF = new TextField();
		
		private Text errorMessage = new Text();
		
		public DataPane() {
			
			setAlignment(Pos.CENTER);
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			setHgap(5.5);
			setVgap(5.5);
			
			errorMessage.setStyle("-fx-stroke: red; -fx-fill: red;");
			
			add(new Label("Projects:"), 0, 0);
			add(projectTF, 1, 0);
			add(new Label("Quizzes:"), 0, 1);
			add(quizTF, 1, 1);
			add(new Label("Midterm:"), 0, 2);
			add(midtermTF, 1, 2);
			add(new Label("Final:"), 0, 3);
			add(finalTF, 1, 3);
			add(errorMessage, 0, 4);
		}
		
		//Used to transfer new user data to the BarChart class
		public double [] getData() {
			return data;
		}
		
		//Clears error message from the stage
		public void removeError() { 
			errorMessage.setText("");
		}
		
		//Stores user input from the 4 Text Fields, returns true if values are valid
		public boolean update() {
			//Clear Text Fields
			String projectData = projectTF.getText();
			projectTF.setText("");
			String quizData = quizTF.getText();
			quizTF.setText("");
			String midtermData = midtermTF.getText();
			midtermTF.setText("");
			String finalData = finalTF.getText();
			finalTF.setText("");
			
			//Turn strings to Doubles
			double tempProject = Double.parseDouble(projectData);
			double tempQuiz = Double.parseDouble(quizData);
			double tempMidterm = Double.parseDouble(midtermData);
			double tempFinal = Double.parseDouble(finalData);
			
			//Check if values are greater than 0 and add up to 100
			//Assign error message accordingly if invalid
			if(tempProject < 0.0) {
				errorMessage.setText("ERROR: Project Input was less then 0.");
				return false;
			}
			if(tempQuiz < 0.0) {
				errorMessage.setText("ERROR: Quiz Input was less then 0.");
				return false;
			}
			if(tempMidterm < 0.0) {
				errorMessage.setText("ERROR: Midterm Input was less then 0.");
				return false;
			}
			if(tempFinal < 0.0) {
				errorMessage.setText("ERROR: Final Input was less then 0.");
				return false;
			}
			if(tempProject + tempQuiz + tempMidterm + tempFinal != 100)
			{
				errorMessage.setText("ERROR: All inputs must add up to 100");
				return false;
			}
			
			//Update data if valid
			data[0] = tempProject;
			data[1] = tempQuiz;
			data[2] = tempMidterm;
			data[3] = tempFinal;
			return true;
		}//end boolean update
		
	}//end class DataPane 
	
	
	//Inner-Class that draws the bar chart based on the user input
	class BarChart extends Pane {
		  Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE,
		    Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK,
		    Color.GRAY};
		  	String [] dataName = {"Projects", "Quizzes", "Midterm", "Final"};
			double [] data = {20, 10, 30, 40};
			double width = 200;
			double height = 200;

		  public BarChart() { paint(); }

		  //Updates the data array for the percentage weights
		  public void update(double [] newData) {
			  for(int i = 0; i < data.length; i++)
				  data[i] = newData[i]; 
			  paint();
		  }
		  
		  //Clears the pane of all Nodes so Chart can be redrawn
		  public void removeAll() {
			  getChildren().remove(0,data.length*3+1);
		  }
		  
		  //Creates Bar Chart
		  public void paint() 
		  {
		 
		    double max = data[0];
		    for (int i=1; i<data.length; i++)
		      max = Math.max(max, data[i]);

		    double barWidth = (width - 10.0) / data.length - 10;
		    double maxBarHeight = height - 30;

		    getChildren().add(new Line(5, height - 10, width - 5, height - 10));

		    int x = 15;
		    for (int i = 0; i < data.length; i++) {
		      double newHeight = maxBarHeight * data[i] / max;
		      double y = height - 10 - newHeight;
		      Rectangle rectangle = new Rectangle(x, y, barWidth, newHeight);
		      rectangle.setFill(colors[i % colors.length]);
		     
		      getChildren().add(rectangle);
		      getChildren().add(new Text(x, y - 7, dataName[i]));
		      getChildren().add(new Text(x+3, height-newHeight+10, (data[i]+"%")));
		      x += barWidth + 10;
		    }
		  }//end void paint
		  
	}//end class BarChart 
	


}// end outer class 
