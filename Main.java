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

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
    Stage window; // The application window that holds the GUI
    Scene scene; // The scene that contain GUI

    /**
     * Start class to call the application in order to launch
     */
    @Override
    public void start(Stage primaryStage) {
        try {



            Stagegenerator newstage = new Stagegenerator();
            scene = newstage.Scene("test.txt");// pass in a file string and generate Scene for
                                               // display


            window = primaryStage;
            window.setScene(scene);
            window.setTitle("New Tournament");
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * launch the main thread
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


}
