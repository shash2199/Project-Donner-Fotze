/**
 * The Team class represents each team in the tournament. 
 * It contains the name and rank (for seeding) of the team.
 */
public interface TeamADT {
	// expected constructor : public Team(String name, int round, int rank);
	/**
	 *  getter for initial rank of the team
	 * 	setter for round is not required because it is set only once when the constructor is called
	 *	according to the position in the file
	 */
	public int getRank();
	/**
	 *  getter for round
	 */
	public int getRound();
	/**
	 * setter for round
	 */
	public void setRound(int round);
	/**
	 *  getter for name of the team
	 */
	public String getName();	
}
