package application;

public class Match implements MatchADT {
    Team teamOne;
    Team teamTwo;
    int scoreOne;
    int scoreTwo;
    
    public Match(Team t1, Team t2) {
        teamOne = t1;
        teamTwo = t2;
        // scores are initialized to -999 to differentiate from actual 0 scores in games.
        scoreOne = -999;
        scoreTwo = -999;
    }
    
    public Match() {
        teamOne = null;
        teamTwo = null;
        scoreOne = -999;
        scoreTwo = -999;
    }
    
    @Override
    public int getScore1() {
        return scoreOne;
    }

    @Override
    public int getScore2() {
        return scoreTwo;
    }

    @Override
    public void setScore(int score1, int score2) {
        scoreOne = score1;
        scoreTwo = score2;
    }

    @Override
    public TeamADT getWinner() {
        // if either score is empty, return null
        if (scoreOne == -999 || scoreTwo == -999) return null;
        return (scoreOne > scoreTwo) ? teamOne : teamTwo;
    }

}
