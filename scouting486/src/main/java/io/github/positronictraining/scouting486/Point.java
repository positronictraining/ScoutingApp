package io.github.positronictraining.scouting486;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction") //to get rid of annoying and inaccurate warnings
@XmlRootElement
public class Point {
	
	//VARIABLES
	@XmlElement
	private String pointName;  //creates an XML read-and-writable variable called pointName for the robot
	@XmlElement
	private String pointPeriod; //creates an XML read-and-writable variable called pointPeriod for the robot
	@XmlElement
	private int pointValue; //creates an XML read-and-writable variable called pointValue for the robot
	@XmlElement
	private int scoringTeam;  //creates an XML read-and-writable variable called scoringTeam for the robot
	
	
	//METHODS
	
	public void setPointType(String pointName, String pointPeriod, int pointValue){ //creates a new point type and stores it's components
		this.pointName = pointName;
		this.pointPeriod = pointPeriod;
		this.pointValue = pointValue;
	}

 	public void newPointScored(Point pointType, int team){ //creates a new score of a predetermined point type for a specified team
 		this.pointName = pointType.getPointName();
 		this.pointPeriod = pointType.getPointPeriod();
 		this.pointValue = pointType.getPointValue();
 		this.scoringTeam = team;
 	}
 	
	public String getPointName(){ //getter for pointName since pointName is private
		return this.pointName;
	}
	public int getPointValue(){ //getter for pointValue since pointValue is private
		return this.pointValue;
	}
	public int getScoringTeam(){ //getter for scoringTeam since scoringTeam is private
		return this.scoringTeam;
	}
	public String getPointPeriod(){ //getter for pointPeriod since pointPeriod is private
		return this.pointPeriod;
	}
}
