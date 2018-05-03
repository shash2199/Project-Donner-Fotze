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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Stagegenerator {
    
    /**
     * Default constructor for creating stagegenerator object
     */
    public Stagegenerator() {

    };

    Pane outside = new Pane();//field for overall display
    
    /**
     * take in a filepath and do all the pre-calculation for displaying 
     * @param filepath
     * @return return a Pane for displaying
     * @throws IOException
     */

    public Scene Scene(String filepath) throws IOException {
        Tournament myTournament = new Tournament(filepath);//generate a tournament object


        if (myTournament.getMatch() != null) {
            Match matches[] = myTournament.getMatch();
            HBox matchbox[] = new HBox[matches.length];// generate a HBox for each match
            for (int i = 0; i < matches.length; i++) {
                HBox top = new HBox(10);
                HBox bootom = new HBox(10);
                VBox holds = new VBox(10);
                HBox bigbox = new HBox(10);
                matches[i].getTextOne().setMaxWidth(50);
                matches[i].getTextTwo().setMaxWidth(50);
                matches[i].getSubmitButton().setMinHeight(62);
                matches[i].getLabelOne().setMinWidth(50);
                matches[i].getLabelTwo().setMinWidth(50);
                matches[i].getLabelOne().setMaxWidth(50);
                matches[i].getLabelTwo().setMaxWidth(50);
                top.getChildren().addAll(matches[i].getLabelOne(), matches[i].getTextOne());
                bootom.getChildren().addAll(matches[i].getLabelTwo(), matches[i].getTextTwo());
                holds.getChildren().addAll(top, bootom);
                bigbox.getChildren().addAll(holds, matches[i].getSubmitButton());
                matchbox[i] = bigbox;
            }


            HBox center = new HBox();
            if (matches.length == 15) { // case for 16
                VBox left = new VBox(50);
                VBox right = new VBox(50);
                VBox left2 = new VBox(150);
                VBox right2 = new VBox(150);
                VBox left3 = new VBox(50);
                VBox right3 = new VBox(50);
                left.getChildren().addAll(matchbox[14], matchbox[13], matchbox[12], matchbox[11]);
                left.setLayoutX(20);
                right.getChildren().addAll(matchbox[7], matchbox[8], matchbox[9], matchbox[10]);
                right.setLayoutX(1200);
                left2.getChildren().addAll(matchbox[6], matchbox[5]);
                left2.setLayoutX(200);
                left2.setLayoutY(65);
                right2.getChildren().addAll(matchbox[3], matchbox[4]);
                right2.setLayoutX(1000);
                right2.setLayoutY(65);
                left3.getChildren().addAll(matchbox[2]);
                left3.setLayoutX(400);
                left3.setLayoutY(170);
                right3.getChildren().addAll(matchbox[1]);
                right3.setLayoutX(800);
                right3.setLayoutY(170);
                center.getChildren().addAll(matchbox[0]);
                center.setLayoutX(600);
                center.setLayoutY(170);
                outside.getChildren().addAll(left, left2, left3, center, right3, right2, right);
            } else if (matches.length == 7) { // case for 8
                VBox left = new VBox(300);
                VBox right = new VBox(300);
                VBox left2 = new VBox(150);
                VBox right2 = new VBox(150);
                left.getChildren().addAll(matchbox[6], matchbox[5]);
                right.getChildren().addAll(matchbox[3], matchbox[4]);
                right.setLayoutX(1200);

                left2.getChildren().addAll(matchbox[2]);
                left2.setLayoutX(300);
                left2.setLayoutY(170);
                right2.getChildren().addAll(matchbox[1]);
                right2.setLayoutX(900);
                right2.setLayoutY(170);

                center.getChildren().addAll(matchbox[0]);
                center.setLayoutX(600);
                center.setLayoutY(170);
                outside.getChildren().addAll(left, left2, center, right2, right);

            } else if (matches.length == 3) { // case for 4
                VBox left = new VBox(100);
                VBox right = new VBox(100);
                left.getChildren().addAll(matchbox[2]);
                left.setLayoutX(400);
                left.setLayoutY(170);

                right.getChildren().addAll(matchbox[1]);
                right.setLayoutX(800);
                right.setLayoutY(170);

                center.getChildren().addAll(matchbox[0]);
                center.setLayoutX(600);
                center.setLayoutY(170);
                outside.getChildren().addAll(left, center, right);
            } else if (matches.length == 1) {// case for 2 team
                center.getChildren().addAll(matchbox[0]);
                center.setLayoutX(600);
                center.setLayoutY(170);
                outside.getChildren().addAll(center);
            }
        } else {// handle the problem when there is no match
            
            if (myTournament.getTeam() == null) {
                Team Teams[] = myTournament.getTeam();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText(
                                "Please check you importing file, there is no team entered in the contest");

                alert.showAndWait();
            } else if (myTournament.getTeam().length == 1) {
                Team Teams[] = myTournament.getTeam();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText("The Winner is: " + Teams[0].getName());
                alert.showAndWait();
            }
        }

        Label operation = new Label("Enter your score in the corresponding text field");// operation
                                                                              // requirement for
                                                                              // users
        operation.setFont(new Font("Arial", 20));
        operation.setLayoutX(550);
        outside.getChildren().add(operation);
        Scene scene1 = new Scene(outside, 1380, 430);
        return scene1;

    };
}
