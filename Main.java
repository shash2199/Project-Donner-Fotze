package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    Stage window;
    Scene scene1;

    @Override
	public void start(Stage primaryStage) {	    
		try {
		   window = primaryStage;
		   
		   
		   Stagegenerator newstage = new Stagegenerator();
		   scene1 = newstage.Scene();
		 
	           window.setScene(scene1);
	           window.setTitle("hello");
	           window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        launch(args);
    }


}
