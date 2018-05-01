package application;

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
	private Team Champion;
	private Team RunnerUp;
	private Team ThirdPlace;
	public Tournament(String filePath) {
		readInput(filePath);
	}
	/**
	 * The method is responsible for reading the input from
	 * 	the file preferably using streams
	 * @param filePath the name of the file from which the
	 * 	names of the teams needs to be extracted
	 */
	 public String readInput(String filePath) {
		 Stream<String> teamStream;
		 List<String> teamsList = new ArrayList<String>();
		 String errorMessage = null;
		 try {
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
				errorMessage = "No Games can be played when the number of teams is less than two!";
				if(teams.length == 1)
					Champion = teams[0];
				else
					teams = null;
			}
			else
				seed();
		} catch (IOException e) {
			errorMessage = "Invalid filePath! :(";
		} finally {
			return errorMessage;
		}
	}
	 
	 /**
	  * Responsible for seeding the teams according to their team ranks and
	  *  store them into the data structure (Array)
	  */
	public void seed() {
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
		while(d > 0) {
			d--;
			matches[d] = new Match(d);
			
		}
		/*
		 * sets the next match for each match besides the one at index 0 which has no next match
		 */
		for(int i = matches.length-1; i > 0; i--) {
			matches[i].setNext(matches[(i-1)/2]);
		}
	}
	 
	 /**
	  * Updates the data structure depending upon 
	  * the result of a match/challenge that is whenever the submit
	  * button is pressed.
	  */
	 public void update();
	public Team[] getTeam(){
		return teams;	
	}
	public Match[] getMatch(){
		return matches;
	}
}
