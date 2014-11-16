package io.github.positronictraining.scouting486;

import java.io.*;
import java.util.ArrayList;



public class Game implements Serializable{
	
	//VARIABLES
	int year;
	String gameName;
	String gameFile;
	private ArrayList<Competition> competitions = new ArrayList<Competition>();
	private ArrayList<Point> pointTypes = new ArrayList<Point>();
	
	//METHODS

	public Game(String gameName) {
		this.gameName = gameName;
		this.gameFile = "ScoutingData/"+gameName+".ser";
		File newFile =  new File(gameFile);
		new File("ScoutingData/").mkdirs();
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Added game file: " + newFile.getAbsolutePath());
	}
	
	public void addNewPointType(String pointName, String pointPeriod, int pointValue ){ //adds a new pointType for storage
		Point newPointType = new Point();
		newPointType.setPointType(pointName, pointPeriod, pointValue);
		this.pointTypes.add(newPointType);
	}
	
	public void addNewCompetition(String competitionName){ //adds a new competition for storage
		Competition newCompetition = new Competition();
		newCompetition.competitionName = competitionName;
		competitions.add(newCompetition);
	}
	
	public void addNewCompetition(String competitionName, Game competitionGame, String competitionStartDate, String competitionEndDate){ //adds a new competition for storage
		Competition newCompetition = new Competition();
		newCompetition.competitionName = competitionName;
		newCompetition.competitionGame = competitionGame;
		newCompetition.competitionStartDate = competitionStartDate;
		newCompetition.competitionEndDate = competitionEndDate;
		competitions.add(newCompetition);
	}
	
	public ArrayList<Competition> getCompetitions(){ //getter for competitions since competitions is private
		return competitions;
	}
	
	public ArrayList<Point> getPointTypes(){//getter for pointTypes since competitions is private
		return pointTypes;
	}
	
	public String toString() {
		return gameName + "[" + year + "]";
		
	}
	
	public boolean matches(Game g) {
		return (this.year == g.year && this.gameName.equals(g.gameName));
	}
	
	public void setGameFile(String gameFile) {
		this.gameFile = gameFile;
	}
	
	public String getGameFile() {
		return gameFile;
	}
}
