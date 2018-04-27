package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Match implements EventHandler<ActionEvent>{
    private Team team1;
    private Team team2;
    private TextField Text1;
    private TextField Text2;
    private Label Label_Team1;
    private Label Label_Team2;
    private Button button;
    private Match next;
    private int Matchnumber;
    
    public Match(){
        Text1 = new TextField();
        Text2 = new TextField();
        Label_Team1 = new Label("unknow");
        Label_Team2 = new Label("unknow");
        button = new Button("submit");
    }
    /**
     * only useful when generate the first round game 
     * @param team1
     * @param team2
     * @param next
     */
    //use the team name to generate team labels and also initialize all the Textfield and button
    public Match(Team team1,Team team2,Match next) {
        
        
    }
    //please implement all the setter and getters as needed 
    
    
    
    /**
     * identify the source of event first
     * Specifically for button. if next==null it is final game, if next.next==null, it is semifinal
     * watch this is you don't know how to handle event: https://www.youtube.com/watch?v=S_JN7zO12H4
     * @param event
     */  
    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }
    
    


    
    
    
}
