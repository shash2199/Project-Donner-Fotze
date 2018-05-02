package application;
/**
 * The Tournament class represents the tournament that is being played. 
 * The tournament class contains the name of the tournament,
 *  Team class instances (which represent each team), an array of matches to be played 
 *  (which acts like our main data structure) 
 *  and specific instances of the Team class which represent the champion, runner-up and the third place holder.
 *  This class is responsible for taking in the input from the file, seeding and storing it in the main data structure.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tournament {
	private Match[] matches;
	private Team[] teams;
	/**
	 * Constructor to call all the respective methods that 
	 * 	read the file, seed the teams and store them in the
	 * 	respective teams and matches arrays.
	 * @param filePath the path of the file that needs to
	 * 	be read
	 * @throws IOException if the file is not read properly
	 */
	public Tournament (String filePath) throws IOException {
		readInput(filePath);
	}
	/**
	 * The method is responsible for reading the input from
	 * 	the file preferably using streams
	 * the method then calls seed to seed all the teams 
	 *	and store 
	 * @param filePath the name of the file from which the
	 * 	names of the teams needs to be extracted
	 * @throws IOException if the file is not accessed properly
	 */
	 private void readInput(String filePath) throws IOException {
		 Stream<String> teamStream;
		 List<String> teamsList = new ArrayList<String>();
		 teamStream = Files.lines(Paths.get(filePath)).map(String::trim);
		//Remove empty lines
		teamStream = teamStream.filter(x -> x != null && !x.equals(""));
		teamsList = teamStream.collect(Collectors.toList());
		int rank = 1;
		teams = new Team[teamsList.size()];
		for(String teamName: teamsList) {
			teams[rank - 1] = new Team(teamName, rank);
			rank++;
		}
		if(teamsList.size() < 2) {
			if(teams.length != 1)
				teams = null;
			}
		else
			seed();
	}
	 
	 /**
	  * Responsible for seeding the teams according to their team ranks and
	  *  store them into the data structure (Array)
	  */
	private void seed() {
		/*
		 * this is the number of matches in the first round 
		 */
		int firstRoundMatchNum = teams.length / 2;
		matches = new Match[teams.length - 1];
		/*
		 * keeps track of how many matches have been my initializes
		 */
		int d = matches.length-1;
		/*
		 * loop initializes the matches by separating the two closest teams to the two ends of the first round
		 *  subsection of the array and the two last place teams to the two ends of the first round subsection
		 *  of the first round array. As the middle of the first round subsection of the array is approached
		 *  the seeds of the teams playing in the matches approach each other.
		 */
		for(int i = 0; i < firstRoundMatchNum; i++) {
			/*
			 * initializes the first half of the first round matches
			 */
			if(i <= firstRoundMatchNum/2 - 1) {
				matches[matches.length - (i+1)] = new Match(teams[i*2], teams[teams.length - (i*2+1)],matches.length - (i+1));
			}
			/*
			 * initializes the second half of the first round matches
			 */
			if(i > firstRoundMatchNum/2 - 1) {
				matches[matches.length - (firstRoundMatchNum - (i-4))] = new Match(teams[(i-4)*2 + 1], teams[teams.length - ((i-3)*2)],matches.length - (firstRoundMatchNum - (i-3)+1));
			}
			d--;
			}
		/*
		 * initializes the rest of the matches
		 */
		while(d >= 0) {
			matches[d] = new Match(d);
			d--;	
		}
		/*
		 * sets the next match for each match besides the one at index 0 which has no next match
		 */
		for(int i = matches.length-1; i > 0; i--) {
			matches[i].setNext(matches[(i-1)/2]);
		}
	}
	
	/**
	 * @return an array containing all the teams
	 */
	public Team[] getTeam(){
		return teams;	
	}
	/**
	 * @return an array containing all the matches
	 */
	public Match[] getMatch(){
		return matches;
	}
}
