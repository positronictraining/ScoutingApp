package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class Competition {		//Makes instances of the Competition XML readable and writable.
	
	//VARIABLES
	//Note: @XmlElement is used to point at the variables that need to be stored in the XML file.
	@XmlElement
	public String competitionName;
	@XmlElement
	private Game competitionGame;
	@XmlElement
	private String competitionStartDate;
	@XmlElement
	private String competitionEndDate;
	@XmlElement
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	@XmlElement
	private ArrayList<Match> matches = new ArrayList<Match>();
	
	
	//METHODS
	
	public void addRobot(int teamNumber){ //adds a new robot with a specified team number to the robots in the competition
		Robot newRobot = new Robot();
		newRobot.teamNumber = teamNumber;
		robots.add(newRobot);
	}
	
	public void addMatch(int red1, int red2, int red3, int blue1, int blue2, int blue3){ //adds a match with specified team numbers to the competition
		Match newMatch = new Match();
		newMatch.setRedAndBlueAlliances(red1, red2, red3, blue1, blue2, blue3);
		matches.add(newMatch);
	}
	
	public Game getCompetitionGame(){ //returns competitionGame because competitionGame is a private variable
		return competitionGame;
	}
	
	public ArrayList<Robot> getRobots(){ //returns robot list because robots is a private variable
		return robots;
	}
	
	public ArrayList<Match> getMatches(){ //returns matches list because matches is a private variable
		return matches;
	}
}
