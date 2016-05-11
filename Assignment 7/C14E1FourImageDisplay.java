/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 14 <br />
 * Exercise: 1 <br />
 * Description: Write a program that displays four images in a grid pane <br />
 * Due: 4/25/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class C14E1FourImageDisplay extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Setting up GridPane properties
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		//Loading images
		Image image1 = new Image("us_flag.gif");
		Image image2 = new Image("england_flag.gif");
		Image image3 = new Image("brazil_flag.gif");
		Image image4 = new Image("china_flag.gif");
		
		//Setting up images to display
		ImageView usa = new ImageView(image1);
		ImageView england = new ImageView(image2);
		ImageView brazil = new ImageView(image3);
		ImageView china = new ImageView(image4);
		
		//Insert each flag into the grid
		pane.add(usa, 0, 0);
		pane.add(england, 0, 1);
		pane.add(brazil, 1, 0);
		pane.add(china, 1, 1);
		
		//Set up scene and stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Four Flags");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
}
