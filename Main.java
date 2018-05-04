///////////////////////////////////////////////////////////////////////////////
// assignment name: Tournament Bracket
// Author: Tianyuan(Rainer) Yuan
// Partner:THEODORE MONTALBANO SHASHWAT SRIVASTAVA GRIFF ZHANG
// Email : tyuan22@wisc.edu
// due date: April 15th 2018
// CS Login: tyuan22
// Credits: none
// known bugs: none
//////////////////////////////////////////////////////////////////////////////

package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    Stage window; // The application window that holds the GUI
    Scene scene; // The scene that contain GUI
    static String filename;// the name of the file

    /**
     * Start class to call the application in order to launch
     */
    @Override
    public void start(Stage primaryStage) {
       
        try {
            StageGenerator newstage = new StageGenerator();
            scene = newstage.Scene("Team.txt");// pass in a file string and generate Scene for
                                               // display
            window = primaryStage;
            window.setScene(scene);
            window.setTitle("Oracle Ultimate Tournament Bracket X");
            window.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("file not found");
            alert.showAndWait();
        }
    }

    /**
     * launch the main thread
     * 
     * @param args
     */
    public static void main(String[] args) {
        filename = args[0];    
        launch(args);
    }
}
