package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Game {
	@XmlElement
	int year;
	@XmlElement
	String gameName;
	@XmlElement
	private ArrayList<Competition> competitions = new ArrayList<Competition>();
	@XmlElement
	private ArrayList<Point> pointTypes = new ArrayList<Point>();
	
	public void addNewPointType(String pointName, String pointPeriod, int pointValue ){
		Point newPointType = new Point();
		newPointType.setPointType(pointName, pointPeriod, pointValue);
		this.pointTypes.add(newPointType);
	}
	
	public void addNewCompetition(String competitionName){
		Competition newCompetition = new Competition();
		newCompetition.competitionName = competitionName;
		competitions.add(newCompetition);
	}
	
	public ArrayList<Competition> getCompetitions(){
		return competitions;
	}
	
	public ArrayList<Point> getPointTypes(){
		return pointTypes;
	}
}
