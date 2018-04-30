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
	 public void seed();
	 
	 /**
	  * Updates the data structure depending upon 
	  * the result of a match/challenge that is whenever the submit
	  * button is pressed.
	  */
	 public void update();
}
