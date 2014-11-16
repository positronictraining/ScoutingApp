package io.github.positronictraining.scouting486;

import java.io.*;

public class Point implements Serializable{
	
	//VARIABLES
	private String pointName;
	private String pointPeriod;
	private int pointValue;
	private String scoringTeam;
	
	
	//METHODS
	
	public void setPointType(String pointName, String pointPeriod, int pointValue){ //creates a new point type and stores it's components
		this.pointName = pointName;
		this.pointPeriod = pointPeriod;
		this.pointValue = pointValue;
	}

 	public void newPointScored(Point pointType, String team){ //creates a new score of a predetermined point type for a specified team
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
	public String getScoringTeam(){ //getter for scoringTeam since scoringTeam is private
		return this.scoringTeam;
	}
	public String getPointPeriod(){ //getter for pointPeriod since pointPeriod is private
		return this.pointPeriod;
	}
}
