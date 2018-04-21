/**
 * The Match class represents each match played between two teams. 
 * It stores the information of two matching teams and winning score.
 * Handling ties would be done in another private method that would called from 
 * 	getWinner()
 */
public interface MatchADT {
	// expected constructor: public Match(Team team1, Team team2)
	/**
	 * Getter for score of team1
	 */
	public int getScore1();
	
	/**
	 * Getter for score of team2
	 */
	public int getScore2();
	
	/**
	 * sets score for both the teams
	 * @param score1 score of first team
	 * @param score2 score of second team
	 */
	public void setScore(int score1, int score2);

	/**
	 * Gets winner by comparing the score 
	 * 	or handling the tie (calls a private method to do so)
	 * @return the winner of the game
 	 */
	public TeamADT getWinner();
}