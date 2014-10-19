package io.github.positronictraining.scouting486;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Point {
	
	@XmlElement
	private String pointName;
	@XmlElement
	private String pointPeriod;
	@XmlElement
	private int pointValue;
	@XmlElement
	private int scoringTeam;
	
	public void setPointType(String pointName, String pointPeriod, int pointValue){
		this.setPointName(pointName);
		this.setPointPeriod(pointPeriod);
		this.setPointValue(pointValue);
	}

 	public void newPointScored(Point pointType, int team){
 		this.setPointName(pointType.getPointName());
 		this.setPointPeriod(pointType.getPointPeriod());
 		this.setPointValue(pointType.getPointValue());
 		this.setScoringTeam(team);
 	}
 	
 	private void setPointName(String pointName){
 		this.pointName = pointName;
 	}
 	
 	private void setPointPeriod(String pointPeriod){
 		this.pointPeriod = pointPeriod;
 	}
 	
 	private void setPointValue(int pointValue){
 		this.pointValue = pointValue;
 	}
 	
 	private void setScoringTeam(int scoringTeam){
 		this.scoringTeam = scoringTeam;
 	}
	
	public String getPointName(){
		return this.pointName;
	}
	public int getPointValue(){
		return this.pointValue;
	}
	public int getScoringTeam(){
		return this.scoringTeam;
	}
	public String getPointPeriod(){
		return this.pointPeriod;
	}
}
