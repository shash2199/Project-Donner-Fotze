package application;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Stagegenerator {
    public Stagegenerator() {

    };

    public Scene Scene() throws IOException {
        
        
// //this block here is the manully created team and matches to test matches
//     Team teams[] = new Team[4];
//     for(int i = 0;i<teams.length;i++) {
//         teams[i] = new Team("Team"+i,i);
//     }
//     Match matches[] = new Match[3];
//     matches[1] = new Match( teams[0],teams[1],1);
//     matches[2] = new Match( teams[2],teams[3],2);
//     matches[0] = new Match(3);
//     matches[1].setNext(matches[2]);
//     matches[2].setNext(matches[2]);
//     matches[0].setNext(null);
        

 //            block to get match from tournament and everything else
           Tournament myTournament = new Tournament("test.txt");
           Match matches[] = myTournament.getMatch();
           for(Match m: matches) {
               System.out.println(m.getLabelOne());
               System.out.println(m.getLabelTwo());
               
           }
           Team Teams[] = myTournament.getTeam();//for later tests 
        

      
        
 // this part s the layout and you guys don't have to fully understand       
            HBox matchbox[]= new HBox[matches.length];
           for(int i = 0; i<matches.length;i++) {
               HBox top  = new HBox(10);
               HBox bootom  = new HBox(10);
               VBox holds = new VBox(10);
               HBox bigbox = new HBox(10);
               matches[i].getTextOne().setMaxWidth(50);
               matches[i].getTextTwo().setMaxWidth(50);
               matches[i].getSubmitButton().setMinHeight(62);;
               top.getChildren().addAll(matches[i].getLabelOne(),matches[i].getTextOne());
               bootom.getChildren().addAll(matches[i].getLabelTwo(),matches[i].getTextTwo());
               holds.getChildren().addAll(top,bootom);
               bigbox.getChildren().addAll(holds,matches[i].getSubmitButton());
               matchbox[i] = bigbox;
           }
       
           
           
        Pane outside = new Pane();
        HBox center = new HBox();
        
        if(false) {
            
        }else if(matches.length==15) { // case for 16
            VBox left = new VBox(50);
            VBox right = new VBox(50);
            VBox left2 = new VBox(150);
            VBox right2 = new VBox(150);
            VBox left3 = new VBox(50);
            VBox right3 = new VBox(50);
            left.getChildren().addAll(matchbox[14],matchbox[13],matchbox[12],matchbox[11]);
            right.getChildren().addAll(matchbox[7],matchbox[8],matchbox[9],matchbox[10]);
            right.setLayoutX(1200);
            left2.getChildren().addAll(matchbox[6],matchbox[5]);
            left2.setLayoutX(200);left2.setLayoutY(65);
            right2.getChildren().addAll(matchbox[3],matchbox[4]);
            right2.setLayoutX(1000);right2.setLayoutY(65);
            left3.getChildren().addAll(matchbox[2]);
            left3.setLayoutX(400);left3.setLayoutY(170);
            right3.getChildren().addAll(matchbox[1]);
            right3.setLayoutX(800);right3.setLayoutY(170);
            center.getChildren().addAll(matchbox[0]);
            center.setLayoutX(600);center.setLayoutY(170);
            outside.getChildren().addAll(left,left2,left3,center,right3,right2,right);
        } else if(matches.length==7) { // case for 8
            VBox left = new VBox(300);
            VBox right = new VBox(300);
            VBox left2 = new VBox(150);
            VBox right2 = new VBox(150);
            left.getChildren().addAll(matchbox[3],matchbox[4]);
            right.getChildren().addAll(matchbox[5],matchbox[6]);
            right.setLayoutX(1200);
            
            left2.getChildren().addAll(matchbox[1]);
            left2.setLayoutX(300);left2.setLayoutY(170);            
            right2.getChildren().addAll(matchbox[2]);
            right2.setLayoutX(900);right2.setLayoutY(170);
            
            center.getChildren().addAll(matchbox[0]);
            center.setLayoutX(600);center.setLayoutY(170);
            outside.getChildren().addAll(left,left2,center,right2,right);
            
        } else if(matches.length==3){  // case for 4
            VBox left = new VBox(100);
            VBox right = new VBox(100);
            left.getChildren().addAll(matchbox[1]);
            left.setLayoutX(400);left.setLayoutY(170);
            
            right.getChildren().addAll(matchbox[2]);
            right.setLayoutX(800);right.setLayoutY(170);
            
            center.getChildren().addAll(matchbox[0]);
            center.setLayoutX(600);center.setLayoutY(170);
            outside.getChildren().addAll(left,center,right);
        } else if (matches.length==1) {//case for 2 team
            center.getChildren().addAll(matchbox[0]);
            center.setLayoutX(600);center.setLayoutY(170);
            outside.getChildren().addAll(center);
        }
        
        
        Scene scene1 = new Scene(outside,1390,450);
        return scene1;

    };
}
