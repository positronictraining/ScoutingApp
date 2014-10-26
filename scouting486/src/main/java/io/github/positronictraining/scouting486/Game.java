package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction") //gets rid of incorrect and annoying eclipse error messages
@XmlRootElement
public class Game {
	
	//VARIABLES
	@XmlElement
	int year; //Creates an XML readable and writable variable for game called year
	@XmlElement
	String gameName;//Creates an XML readable and writable variable for game called gameName
	@XmlElement
	private ArrayList<Competition> competitions = new ArrayList<Competition>();//Creates an XML readable and writable variable for game called competitions
	@XmlElement
	private ArrayList<Point> pointTypes = new ArrayList<Point>();//Creates an XML readable and writable variable for game called pointTypes
	
	
	//METHODS

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
	
	public ArrayList<Competition> getCompetitions(){ //getter for competitions since competitions is private
		return competitions;
	}
	
	public ArrayList<Point> getPointTypes(){//getter for pointTypes since competitions is private
		return pointTypes;
	}
}
