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
		   
		   
	   TextField t1 = new TextField ();
	   TextField t2 = new TextField ();        
           TextField t3 = new TextField ();
           TextField t4 = new TextField ();
           TextField t5 = new TextField ();
           TextField t6 = new TextField ();       
           TextField t7 = new TextField ();
           TextField t8 = new TextField ();
           TextField t9 = new TextField ();
           TextField t10 = new TextField ();           
           TextField t11 = new TextField ();
           TextField t12 = new TextField ();
           TextField t13 = new TextField ();
           TextField t14 = new TextField ();           
           TextField t15 = new TextField ();
           TextField t16 = new TextField ();
           TextField t17 = new TextField ();
           TextField t18 = new TextField ();           
           TextField t19 = new TextField ();
           TextField t20 = new TextField ();
           TextField t21 = new TextField ();
           TextField t22 = new TextField ();           
           TextField t23 = new TextField ();
           TextField t24 = new TextField ();
           TextField t25 = new TextField ();
           TextField t26 = new TextField ();           
           TextField t27 = new TextField ();
           TextField t28 = new TextField ();
           TextField t29 = new TextField ();           
           TextField t30 = new TextField ();
           
	   Label label0 = new Label("Team 1");
	   Label label1 = new Label("Team 2");
	   Label label2 = new Label("Team 3");
	   Label label3 = new Label("Team 4");
           Label label4 = new Label("Team 5");
           Label label5 = new Label("Team 6");
           Label label6 = new Label("Team 7");
           Label label7 = new Label("Team 8");
           Label label8 = new Label("Team 9");
           Label label9 = new Label("Team 10");
           Label label10 = new Label("Team 11");
           Label label11 = new Label("Team 12");
           Label label12 = new Label("Team 13");
           Label label13 = new Label("Team 14");
           Label label14 = new Label("Team 15");
           Label label15 = new Label("Team 16");
           
           Button button1 =new Button("submit");
           Button button2 =new Button("submit");
           Button button3 =new Button("submit");
           Button button4 =new Button("submit");
           Button button5 =new Button("submit");
           Button button6 =new Button("submit");
           Button button7 =new Button("submit");
           Button button8 =new Button("submit");
           Button button9 =new Button("submit");
           Button button10 =new Button("submit");
           Button button11 =new Button("submit");
           Button button12 =new Button("submit");
           Button button13 =new Button("submit");
           Button button14 =new Button("submit");
           Button button15 =new Button("submit");

  //layout left         
		   VBox layout1 = new VBox(12);
		   layout1.getChildren().addAll(label0,t1,button1,label15,t2,label7,t3,button2,label8,t4,label3,t5,button3,label12,t6,label4,t7,button4,label11,t8);
		   layout1.setLayoutX(0);
		   

//layout right
		   VBox layout2 = new VBox(12);
		   layout2.getChildren().addAll(label1,t9,button5,
		                   label14,t10,label6,t11,button6,label9,t12,label5,t13,button7,label10,t14,label2,t15,button8,label13,t16);
		   layout2.setLayoutX(1300);
		           
//layoutV2
		   Label s1 = new Label("Team s1");
           Label s2 = new Label("Team s2");
           Label s3 = new Label("Team s3");
           Label s4 = new Label("Team s4");
           Label s5 = new Label("Team s5");
           Label s6 = new Label("Team s6");
           Label s7 = new Label("Team s7");
           Label s8 = new Label("Team s8");
           

           
		   VBox layout3 = new VBox(35);
		   
		   layout3.getChildren().addAll(s1,t17,button9,s2,t18,s3,t19,button10,s4,t20);
		   layout3.setLayoutX(220);
		   layout3.setLayoutY(50);
		   
		   
//layout right2 
		   VBox layout4 = new VBox(35);
		   layout4.getChildren().addAll(s5,t21,button11,s6,t22,s7,t23,button12,s8,t24);
           layout4.setLayoutX(1100);
           layout4.setLayoutY(50);

           
//layout left 3
           Label r1 = new Label("Team t1");
           Label r2 = new Label("Team t2");
           Label r3 = new Label("Team t3");
           Label r4 = new Label("Team t4");
           
           VBox layout5 = new VBox(50);
           layout5.getChildren().addAll(r1,t25,button13,r2,t26);
           layout5.setLayoutX(440);
           layout5.setLayoutY(100);

 //layout right 3          
           VBox layout6 = new VBox(50);
           layout6.getChildren().addAll(r3,t27,button14,r4,t28);
           layout6.setLayoutX(910);
           layout6.setLayoutY(100);
           
           
         
		   
//layout center 
		   Label f1 = new Label("Team f1");
           Label f2 = new Label("Team f2");
           VBox  c1 = new VBox(10);
           c1.getChildren().addAll(f1,t29);
           VBox  c2 = new VBox(10);
           c2.getChildren().addAll(f2,t30);
		   HBox layout7 = new HBox(20);
		   
		   
		   layout7.getChildren().addAll(c1,button15,c2);
		   layout7.setLayoutX(500);
		   layout7.setLayoutY(250);
		   
	
		   
           Pane p = new Pane();
           p.getChildren().addAll(layout1,layout2,layout3,layout4,layout5,layout6,layout7);
	          scene1 = new Scene(p,1500,700);
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
