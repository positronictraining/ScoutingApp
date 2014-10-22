package io.github.positronictraining.scouting486;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Competition {
	
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
	
	
	public void addRobot(int teamNumber){
		Robot newRobot = new Robot();
		newRobot.teamNumber = teamNumber;
		robots.add(newRobot);
	}
	
	public void addMatch(int red1, int red2, int red3, int blue1, int blue2, int blue3){
		Match newMatch = new Match();
		newMatch.setRedAndBlueAlliances(red1, red2, red3, blue1, blue2, blue3);
		matches.add(newMatch);
	}
	
	
	public Game getCompetitionGame(){
		return competitionGame;
	}
	
	public ArrayList<Robot> getRobots(){
		return robots;
	}
	
	public ArrayList<Match> getMatches(){
		return matches;
	}
}
