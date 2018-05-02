package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
      
    static Match[] semifinals = new Match[2];
    
    /**
     * Create a new Match object provided the two teams. Initialize the two labels
     * accordingly. Scores for both teams are initialized to -999 to differentiate
     * from actual zero scores in games.
     * @param t1    Team One
     * @param t2    Team Two
     */
    public Match(Team t1, Team t2, int mNum) {
        matchNum = mNum;
        setTeamOne(t1);
        setTeamTwo(t2);
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
                                if (next == null) { // if this game is the final game
                                    Team champion = getWinner();
                                    Team secondPlace;
                                    if (teamOne.equals(champion)) secondPlace = teamTwo;
                                    else secondPlace = teamOne;
                                    // Compute third place team
                                    Team thirdPlace;
                                    Team semiOneLoser;
                                    int loserOneScore;
                                    if (semifinals[0].scoreOne > semifinals[0].scoreTwo) {
                                        semiOneLoser = teamTwo;
                                        loserOneScore = scoreTwo;
                                    }
                                    else { 
                                        semiOneLoser = teamOne;
                                        loserOneScore = scoreOne;
                                    }
                                    Team semiTwoLoser;
                                    int loserTwoScore;
                                    if (semifinals[1].scoreOne > semifinals[1].scoreTwo) {
                                        semiTwoLoser = teamTwo;
                                        loserTwoScore = scoreTwo;
                                    }
                                    else { 
                                        semiTwoLoser = teamOne;
                                        loserTwoScore = scoreOne;
                                    }
                                    if (loserOneScore > loserTwoScore) thirdPlace = semiOneLoser;
                                    else thirdPlace = semiTwoLoser;
                                    Alert results = new Alert(AlertType.INFORMATION);
                                    results.setTitle("Tournament Results");
                                    results.setHeaderText(null);
                                    results.setContentText("Champion: " + champion.getName() + "\n"
                                                  + "Second place: " + secondPlace.getName() + "\n"
                                                  + "Third place: " + thirdPlace.getName());
                                    results.showAndWait();
                                } else if (next.next == null) { // if this game is semifinal
                                    if (matchNum % 2 == 0) next.setTeamTwo(getWinner());
                                    // store game info to determine third place after grand final
                                    else next.setTeamOne(getWinner());
                                    storeSemifinal();
                                } else { // if this is a normal game
                                    if (matchNum % 2 == 0) next.setTeamTwo(getWinner());
                                    else next.setTeamTwo(getWinner());
                                }
                            }});
    }
    
    /**
     * Create a new Match object with no team information. Initialize the two labels
     * to "TBD" (To Be Decided). Scores for both teams are initialized to -999.
     */
    public Match(int mNum) {
        matchNum = mNum;
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
                                if (next == null) { // if this game is the final game
                                    Team champion = getWinner();
                                    Team secondPlace;
                                    if (teamOne.equals(champion)) secondPlace = teamTwo;
                                    else secondPlace = teamOne;
                                    // Compute third place team
                                    Team thirdPlace;
                                    Team semiOneLoser;
                                    int loserOneScore;
                                    if (semifinals[0].scoreOne > semifinals[0].scoreTwo) {
                                        semiOneLoser = teamTwo;
                                        loserOneScore = scoreTwo;
                                    }
                                    else { 
                                        semiOneLoser = teamOne;
                                        loserOneScore = scoreOne;
                                    }
                                    Team semiTwoLoser;
                                    int loserTwoScore;
                                    if (semifinals[1].scoreOne > semifinals[1].scoreTwo) {
                                        semiTwoLoser = teamTwo;
                                        loserTwoScore = scoreTwo;
                                    }
                                    else { 
                                        semiTwoLoser = teamOne;
                                        loserTwoScore = scoreOne;
                                    }
                                    if (loserOneScore > loserTwoScore) thirdPlace = semiOneLoser;
                                    else thirdPlace = semiTwoLoser;
                                    Alert results = new Alert(AlertType.INFORMATION);
                                    results.setTitle("Tournament Results");
                                    results.setHeaderText(null);
                                    results.setContentText("Champion: " + champion.getName() + "\n"
                                                  + "Second place: " + secondPlace.getName() + "\n"
                                                  + "Third place: " + thirdPlace.getName());
                                    results.showAndWait();
                                } else if (next.next == null) { // if this game is semifinal
                                    if (matchNum % 2 == 0) next.setTeamTwo(getWinner());
                                    // store game info to determine third place after grand final
                                    else next.setTeamOne(getWinner());
                                    storeSemifinal();
                                } else { // if this is a normal game
                                    if (matchNum % 2 == 0) next.setTeamTwo(getWinner());
                                    else next.setTeamTwo(getWinner());
                                }
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
    
    public Label getLabelOne() { return teamOneLabel; }
    public Label getLabelTwo() { return teamTwoLabel; }
    public TextField getTextOne() { return teamOneIn; }
    public TextField getTextTwo() { return teamTwoIn; }
    public Button getSubmitButton() { return submitButton; }
    public void setNext(Match n) { next = n; }
    public Match getNext() { return next; }
    
    private void storeSemifinal() {
        if (semifinals[0] == null) semifinals[0] = this;
        else semifinals[1] = this;
    }
    
    public void setTeamOne(Team t1) {
        teamOne = t1;
        teamOneLabel.setText(t1.getName());
    }
    
    public void setTeamTwo(Team t2) {
        teamTwo = t2;
        teamTwoLabel.setText(t2.getName());
    }

      
}
