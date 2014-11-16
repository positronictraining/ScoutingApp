package io.github.positronictraining.scouting486;

import java.io.*;
import java.util.ArrayList;



public class Competition implements Serializable{
	
	//VARIABLES
	public String competitionName;
	public Game competitionGame;
	public String competitionStartDate;
	public String competitionEndDate;
	public ArrayList<Robot> robots = new ArrayList<Robot>();
	public ArrayList<Match> matches = new ArrayList<Match>();
	
	
	//METHODS
	
	public Object[] teamStats(String team){
		
		Object[] teamStats = new Object[4];
		
		int teamWins = 0;
		int teamLosses = 0;
		int totalPoints = 0;
		int totalPenalties = 0;
		
		for ( int i=0; i< matches.size(); i++){
			for(int j = 0; j<3; j++){
				
				for( int k=0; k < matches.get(i).getPointsScored().size(); k++){
					if (team == matches.get(i).getPointsScored().get(k).getScoringTeam()){
						totalPoints = totalPoints + matches.get(i).getPointsScored().get(k).getPointValue();
					}
				}
				
				for( int k=0; k < matches.get(i).getPenalties().size(); k++){
					if (team == matches.get(i).getPenalties().get(k).getScoringTeam()){
						totalPenalties = totalPenalties + matches.get(i).getPenalties().get(k).getPointValue();
					}
				}
				
				if (team == matches.get(i).blueAlliance[j]){					
					if(matches.get(i).blueWon){
						teamWins++;
					}else{
						teamLosses++;
					}
				}else if(team == matches.get(i).redAlliance[j]){
					if(matches.get(i).redWon){
						teamWins++;
					}else{
						teamLosses++;
					}
				}
			}
		}
		teamStats[0] = teamWins;
		teamStats[1] = teamLosses;
		teamStats[2] = totalPoints;
		teamStats[3] = totalPenalties;
		return teamStats;
	}
	
	public void addRobot(String teamNumber){ //adds a new robot with a specified team number to the robots in the competition
		Robot newRobot = new Robot();
		newRobot.teamNumber = teamNumber;
		robots.add(newRobot);
	}
	
	public void addMatch(String red1, String red2, String red3, String blue1, String blue2, String blue3){ //adds a match with specified team numbers to the competition
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
	public String toString() {
		return competitionName;
	}
}
