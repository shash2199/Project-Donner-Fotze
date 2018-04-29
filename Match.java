package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Match implements MatchADT {
    private Team teamOne;
    private Team teamTwo;
    private int scoreOne = -999;
    private int scoreTwo = -999;
    private Button submitButton = new Button("OK");
    private Label teamOneLabel = new Label("TBD"); 
    private Label teamTwoLabel = new Label("TBD");
    private TextField teamOneIn = new TextField();
    private TextField teamTwoIn = new TextField();
    private Match next;
    private int matchNum;
    
    /**
     * Create a new Match object provided the two teams. Initialize the two labels
     * accordingly. Scores for both teams are initialized to -999 to differentiate
     * from actual zero scores in games.
     * @param t1    Team One
     * @param t2    Team Two
     */
    public Match(Team t1, Team t2, int mNum) {
        matchNum = mNum;
        teamOne = t1;
        teamTwo = t2;
        teamOneIn = new TextField();
        teamTwoIn = new TextField();
        teamOneLabel = new Label(teamOne.getName());
        teamTwoLabel = new Label(teamTwo.getName());
        
        // Event listeners and handlers
        teamOneIn.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                scoreOne = Integer.parseInt(teamOneIn.getText());
                            }});
        teamTwoIn.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                scoreTwo = Integer.parseInt(teamTwoIn.getText());
                            }});
        submitButton.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (matchNum % 2 == 0) next.teamTwo = getWinner();
                                else next.teamOne = getWinner();
                            }});
    }
    
    /**
     * Create a new Match object with no team information. Initialize the two labels
     * to "TBD" (To Be Decided). Scores for both teams are initialized to -999.
     */
    public Match(int mNum) {
        matchNum = mNum;
        teamOneIn = new TextField();
        teamTwoIn = new TextField();
        // Event listeners and handlers
        teamOneIn.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                scoreOne = Integer.parseInt(teamOneIn.getText());
                            }});
        teamTwoIn.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                scoreTwo = Integer.parseInt(teamTwoIn.getText());
                            }});
        submitButton.setOnAction(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (matchNum % 2 == 0) next.teamTwo = getWinner();
                                else next.teamOne = getWinner();
                            }});
    }
    
    /** Return TeamOne's score. */
    @Override
    public int getScore1() {
        return scoreOne;
    }

    /** Return TeamTwo's score. */
    @Override
    public int getScore2() {
        return scoreTwo;
    }
    
    /**
     * Set the scores for both teams.
     * @param score1    Score of Team One.
     * @param score2    Score of Team Two.
     */
    @Override
    public void setScore(int score1, int score2) {
        scoreOne = score1;
        scoreTwo = score2;
    }
    

    /**
     * Determine the winner of the match based on the scores. Throws an
     * IllegalArgumentException if the two scores are the same.
     * @return  The winning team.
     */
    @Override
    public Team getWinner() {
        // if either score is empty, return null
        if (scoreOne == -999 || scoreTwo == -999) return null;
        if (scoreOne == scoreTwo) throw new IllegalArgumentException();
        return (scoreOne > scoreTwo) ? teamOne : teamTwo;
    }

      
}
