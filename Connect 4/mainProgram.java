/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Description: Final Project: Connect 4 <br />
 * Due: 5/11/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainProgram extends Application{

	//Constants used to keep uniform formating and board definitions
	private static final int COLS = 7;
	private static final int ROWS = 6;
	private static final int CELL_SIZE = 100;
	private static final int RADIUS = 45;
	
	//Panes and Texts used in the scene
	StackPane centerPane = new StackPane();			//Holds GridPane (board), game over pane, and winning player Text
	private GridPane gameBoard = new GridPane();	//Has cells which show board format and hold the 'discs' with corrisponding coordinates
	private BorderPane base = new BorderPane();		//Main pane that everything goes inside
	private boolean isRedTurn = true;				//Boolean to keep trake of player turn	
	private Circle[][] discs = new Circle[ROWS][COLS];	//Holds the circles to be filled with appropriate player color, used to check win conditions
	private Rectangle endSlide = new Rectangle(COLS*CELL_SIZE, ROWS*CELL_SIZE); //Pops up after a win
	private Text winner = new Text();				//Shows the player who one on top of center pane
	private Text showPlayerTurn = new Text();		//Displays whos turn it is in the top pane
	
	@Override
	public void start(Stage primaryStage) { //throws Exception {
		
		List<Rectangle> showCols = createShowCols();	//Holds green rectangles to represent column the mouse is hoving over
		Button resetButton = new Button("New Game");	//Avaiable to clear the board at anytime
		
		//Formatting panes
		resetButton.setAlignment(Pos.CENTER);
		resetButton.setPadding(new Insets(10));
		resetButton.setFont(new Font("Arial Black", 24));
		gameBoard.setAlignment(Pos.CENTER);
		
		//Sets up panes for a new game (Handles clearing and reseting all old info from previous gmae
		createBoard();

		//Hides the transparent white win pane, and Text showing winner until the end
		endSlide.setFill(Color.TRANSPARENT);
		winner.setFont(new Font("Arial Black", 72));
		winner.setFill(Color.TRANSPARENT);
		
		//Insert Board, End slide, Winner Text, and The Column rectangles into one Pane
		centerPane.getChildren().add(gameBoard);
		centerPane.getChildren().add(endSlide);
		centerPane.getChildren().add(winner);
		for(Rectangle x : showCols)
			centerPane.getChildren().add(x);
		centerPane.setPadding(new Insets(0,0,10,0));	//Give some space between board and Reset button on bottom
		
		//Place board in center, Reset button on bottom, and Players Turn text on top
		base.setCenter(centerPane);
		base.setBottom(resetButton);
		base.setTop(showPlayerTurn);
		
		//Center the button and Text
		base.setAlignment(resetButton, Pos.CENTER);
		base.setAlignment(showPlayerTurn, Pos.CENTER);
		
		//Create and Register the Button Handler handler
		resetButton.setOnAction(new ResetGameHandlerClass());
		
		//Set up scene and stage with the base pane
		Scene scene = new Scene(base);
		primaryStage.setTitle("Connect 4");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//Changes Text in Top Pane to show which Player goes next
	private void showNextTurn() {
		if(isRedTurn == true) {
			showPlayerTurn.setText("Reds Turn"); 
			showPlayerTurn.setFill(Color.RED);
		}
		else {
			showPlayerTurn.setText("Yellows Turn");
			showPlayerTurn.setFill(Color.YELLOW);
		}
	}
	
	//Resets all values to New Game status. Removes all old discs from board and
	// inserts new ones.
	private void createBoard() {
		isRedTurn = true;
		centerPane.setDisable(false);
		endSlide.setFill(Color.TRANSPARENT);
		winner.setFill(Color.TRANSPARENT);
		winner.setStroke(Color.TRANSPARENT);
		showPlayerTurn.setFont(new Font("Arial Black", 48));
		showPlayerTurn.setStroke(Color.BLACK);
		showNextTurn();
		gameBoard.getChildren().clear();
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				Rectangle tile = new Rectangle(CELL_SIZE, CELL_SIZE);
				Circle circle = new Circle(RADIUS);
				
				//Center in middle of Square tile
				circle.centerXProperty().set(CELL_SIZE/2);
				circle.centerYProperty().set(CELL_SIZE/2);
				
				//Each cell is a complex shape, showing the absence of a circle
				Shape cell = Path.subtract(tile, circle);
				cell.setFill(Color.CORNFLOWERBLUE);
				
				//Using private data member, we fill each cell from corrisponding corridates in the 2D array
				discs[i][j] = new Circle(RADIUS, Color.WHITE);
				discs[i][j].setStroke(Color.BLACK);
				StackPane stack = new StackPane();
				stack.getChildren().addAll(cell,discs[i][j]);
				
				//Insert into GridPane board
				gameBoard.add(stack, j, i);
			}
		}
	}
	
	//Creates a Rectangle for each Column to show user where next move would go based on
	// mouse position.
	private List<Rectangle> createShowCols() {
		List<Rectangle> cols = new ArrayList<>();
		
		for(int j = 0; j < COLS; j++) {
			Rectangle show_col = new Rectangle(CELL_SIZE, CELL_SIZE * ROWS);
			show_col.setTranslateX(CELL_SIZE * j - (3*CELL_SIZE));
			show_col.setFill(Color.TRANSPARENT);
			
			//Column highlighted with transparent Green when mouse enters Column
			show_col.setOnMouseEntered(e -> show_col.setFill(Color.rgb(152,251,152,0.5)));
			
			//Highlight hidden when mouse not in column
			show_col.setOnMouseExited(e -> show_col.setFill(Color.TRANSPARENT));
			
			//Send column number to be used in determining Disc placement
			//Clicking anywhere in a highlighted column will trigger this
			show_col.setOnMouseClicked(new MoveSelectedHandlerClass(j));
			
			cols.add(show_col);
		}
		return cols;
	}
	
	
	//When game is determined as Won, The Center Pane is frozen with the Winner shown!
	private void endGame() { 
		//Blurr the game board
		endSlide.setFill(Color.WHITESMOKE);
		endSlide.setOpacity(.8);
		
		//Figure out winner by whos turn it was
		if(isRedTurn == true) {
			winner.setText("Red Wins!"); 
			winner.setFill(Color.RED);
			winner.setStroke(Color.BLACK);
		}
		else {
			winner.setText("Yellow Wins!");
			winner.setFill(Color.YELLOW);
			winner.setStroke(Color.BLACK);
		}
		
		//Lock game board so no moves can be made until New Game is pressed
		centerPane.setDisable(true);
	}
	
	
	//-----------------------------------------------------------------------
	// Checking each direction for a win based on Fill color of current player
	//------------------------------------------------------------------------
	public boolean checkDown(Paint player, int row, int col) {
    	//add to row
    	if(row + 1 < ROWS && discs[row+1][col].getFill() == player)
    		if(row + 2 < ROWS && discs[row+2][col].getFill() == player)
    			if(row + 3 < ROWS && discs[row+3][col].getFill() == player)
        			return true;
    	return false;
	}   
    public boolean checkUp(Paint player, int row, int col) {
    	//subtract from row
    	if(row - 1 > -1 && discs[row-1][col].getFill() == player)
    		if(row - 2 > -1 && discs[row-2][col].getFill() == player)
    			if(row - 3 > -1 && discs[row-3][col].getFill() == player)
        			return true;
    	return false;
    }  
    public boolean checkLeft(Paint player, int row, int col) {
    	//subtract from column
    	if(col - 1 > -1 && discs[row][col-1].getFill() == player)
    		if(col - 2 > -1 && discs[row][col-2].getFill() == player)
    			if(col - 3 > -1 && discs[row][col-3].getFill() == player)
        			return true;
    	return false;
    }   
    public boolean checkRight(Paint player, int row, int col) {
    	//add to column
    	if(col + 1 < COLS && discs[row][col+1].getFill() == player)
    		if(col + 2 < COLS && discs[row][col+2].getFill() == player)
    			if(col + 3 < COLS && discs[row][col+3].getFill() == player)
        			return true;
    	return false;
    }
    
    //(Bottom Right -> Top Left)
    public boolean checkDiagUL(Paint player, int row, int col) {
    	//subtract from row and column
    	if(col - 1 > -1 && row - 1 > -1 && discs[row-1][col-1].getFill() == player)
    		if(col - 2 > -1 && row - 2 > -1 && discs[row-2][col-2].getFill() == player)
    			if(col - 3 > -1 && row - 3 > -1 && discs[row-3][col-3].getFill() == player)
        			return true;
    	return false;
    }
    
    //(Bottom Left -> Top Right)
    public boolean checkDiagUR(Paint player, int row, int col) {
    	//sub row, add col
    	if(col + 1 < COLS && row - 1 > -1 && discs[row-1][col+1].getFill() == player)
    		if(col + 2 < COLS && row - 2 > -1 && discs[row-2][col+2].getFill() == player)
    			if(col + 3 < COLS && row - 3 > -1 && discs[row-3][col+3].getFill() == player)
        			return true;
    	return false;
    }
    
    //(Top Left -> Bottom Right)
    public boolean checkDiagDR(Paint player, int row, int col) {
    	//add row and col
    	if(col + 1 < COLS && row + 1 < ROWS && discs[row+1][col+1].getFill() == player)
    		if(col + 2 < COLS && row + 2 < ROWS && discs[row+2][col+2].getFill() == player)
    			if(col + 3 < COLS && row + 3 < ROWS && discs[row+3][col+3].getFill() == player)
        			return true;
    	return false;
    }
    
    //(Top Right -> Bottom Left)
    public boolean checkDiagDL(Paint player, int row, int col) {
    	//add row, sub col
    	if(col - 1 > -1 && row + 1 < ROWS && discs[row+1][col-1].getFill() == player)
    		if(col - 2 > -1 && row + 2 < ROWS && discs[row+2][col-2].getFill() == player)
    			if(col - 3 > -1 && row + 3 < ROWS && discs[row+3][col-3].getFill() == player)
        			return true;
    	return false;
    }
    
    //Check against color values across the board
	public boolean checkWin(int row, int col) {
		Paint playerColor = discs[row][col].getFill();
		boolean ret = false;
    	for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
            	if(discs[i][j].getFill() == playerColor)
            	{
	            	ret |= checkDown(playerColor, i, j);
	            	ret |= checkUp(playerColor, i, j);
	            	ret |= checkLeft(playerColor, i, j);
	            	ret |= checkRight(playerColor, i, j);
	            	ret |= checkDiagUL(playerColor, i, j);
	            	ret |= checkDiagUR(playerColor, i, j);
	            	ret |= checkDiagDR(playerColor, i, j);
	            	ret |= checkDiagDL(playerColor, i, j);
            	}
            }
        }
    	return ret; //True = Win : False = No Win Yet
		
	}
	
	
	//Used when column is selected to make a move, Sees if move can be made, then checks for a win
	class MoveSelectedHandlerClass implements EventHandler<MouseEvent> {
		private int colChosen;
		
		//Take in the column selected by the user to know where to place the disc
		public MoveSelectedHandlerClass(int col) {
			this.colChosen = col;
		}
		
		@Override
		public void handle(MouseEvent event) {
			
			//Find bottom most available stop to fill in the given column
			for(int i = ROWS-1; i >= 0; i--) {	
				if(discs[i][colChosen].getFill() == Color.WHITE) {
					//Fills bottom white disc of selected column with color of current player
					discs[i][colChosen].setFill(isRedTurn == true ? Color.RED : Color.YELLOW);
					
					//See if player has won, if so set the endGame conditions
					if(checkWin(i, colChosen)) 
						endGame();
					
					isRedTurn = !isRedTurn;	//Switch to other players turn
					showNextTurn();			//Display the new players turn to user
					break;					//Exit looping
				}
			}
			
		}
		
	}
	
	
	//When resetButton is pressed, createBoard is called to refresh all values
	class ResetGameHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e)
		{
			createBoard();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}// end mainProgram class
