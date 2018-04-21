/**
 * The Tournament class represents the tournament that is being played. 
 * The tournament class contains the name of the tournament,
 *  Team class instances (which represent each team), an array of matches to be played 
 *  (which acts like our main data structure) 
 *  and specific instances of the Team class which represent the champion, runner-up and the third place holder.
 *  This class is responsible for taking in the input from the file, seeding and storing it in the main data structure.
 */
public interface TournamentADT {
// default constructor expected
	/**
	 * The method is responsible for reading the input from
	 * 	the file preferably using streams
	 * @param fileName the name of the file from which the
	 * 	names of the teams needs to be extracted
	 */
	 public void readInput(String fileName);
	 
	 /**
	  * Responsible for seeding the teams according to their team ranks and
	  *  store them into the data structure (Array)
	  */
	 public void seed();
	 
	 /**
	  * Updates the data structure depending upon 
	  * the result of a match/challenge that is whenever the submit
	  * button is pressed.
	  */
	 public void update();
}
