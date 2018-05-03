package application;
/**
 * The Tournament class represents the tournament that is being played. 
 * The tournament class contains the name of the tournament,
 *  Team class instances (which represent each team), an array of matches to be played 
 *  (which acts like our main data structure) 
 *  and specific instances of the Team class which represent the champion, runner-up and the third place holder.
 *  This class is responsible for taking in the input from the file, seeding and storing it in the main data structure.
 *  The seeding algorithm taken from online source 
 * @author Maulin Vasavada	 
 * from: https://coderanch.com/t/371069/java/arrange-numbers
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
	  * helper method gotten from online source that help algorithm seed the teams
	  * @author Maulin Vasavada
	  * from: https://coderanch.com/t/371069/java/arrange-numbers
	  * @param N
	  * @param n
	  * @return
	  */
	 public static double f(int N, int n) {
		 double d = Math.pow(2,N) +1;
		 if ( n == 2) {
		 return d -1;
		 } else if ( n % 2 == 1 ) {
		 return  d - f(N-1, (n+1)/2);
		 } else {
		 return f(N-1,n/2);
		 }
		 }
	 /**
	  * Returns log base 2 of input as long as the input is a power of two and greater than 0;
	  * @param x
	  * @return log base 2 of the input
	  */
	 private int log(int x) {
		 int count = 0;
		 while(x > 1) {
			 x = x/2;
			 count++;
		 }
		 return count;
	 }
	 /**
	  * Responsible for seeding the teams according to their team ranks and
	  *  store them into the data structure (Array)
	  * The seeding algorithm taken from online source 
	  * @author Maulin Vasavada
	  * from: https://coderanch.com/t/371069/java/arrange-numbers
	  *  
	  */
	private void seed() {
		/*
		 * seeding algorithm gotten from online source
		 * cited in the java docs of method and class
		 */
		// seeding algorithm (from online source) begins		
		int N = log(teams.length);
		double d = Math.pow(2,N);
		double d1 = d +1;
		double[] data = new double[(int)d+1];
		//System.out.println("d="+d);
		data[0] = -1;
		data[1] = 1;
		data[2] = d;
		data[(int)d] = d-1;
		data[(int)d-1] = 2;
		for(int i=4; i < (int)d; i+= 2 ) {
		data[i-1] = f(N,i);
		data[i] = d1 - data[i-1];
		}
		// seeding algorithm (from online source) ends
		/*
		 * this is the number of matches in the first round 
		 */
		int firstRoundMatchNum = teams.length / 2;
		matches = new Match[teams.length - 1];
		/*
		 * keeps track of how many matches have been my initializes
		 */
		int b = matches.length - 1;
		/*
		 * loop initializes the matches by separating the two closest teams to the two ends of the first round
		 *  subsection of the array and the two last place teams to the two ends of the first round subsection
		 *  of the first round array. As the middle of the first round subsection of the array is approached
		 *  the seeds of the teams playing in the matches approach each other.
		 */
		for(int i = 0; i < teams.length; i=i+2) {
			matches[matches.length-1-i/2] = new Match(teams[(int) data[i+1]-1],teams[(int) data[i+2]-1],matches.length-1-i);
			b--;
		}
		/*
		 * initializes the rest of the matches
		 */
		while(b >= 0) {
			matches[b] = new Match(b);
			b--;
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
