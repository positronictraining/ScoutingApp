package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Match {
	
	@XmlElement
	public int[] blueAlliance = new int[3];
	@XmlElement
	public int[] redAlliance = new int[3];
	@XmlElement
	private int blueAllianceScore;
	@XmlElement
	private int redAllianceScore;
	@XmlElement
	private String gameComment;
	@XmlElement
	private ArrayList<Point> pointsScored = new ArrayList<Point>();
	@XmlElement
	private ArrayList<Point> penalties = new ArrayList<Point>();
	
	public void setRedAndBlueAlliances(int red1, int red2, int red3, int blue1, int blue2, int blue3){
		this.redAlliance[0] = red1;
		this.redAlliance[1] = red2;
		this.redAlliance[2] = red3;
		this.blueAlliance[0] = blue1;
		this.blueAlliance[1] = blue2;
		this.blueAlliance[2] = blue3;
	}
	
	public void pointScored(Game game, int pointTypeIndex, int scoringTeam, String alliance){
		Point scoredPoint = new Point();
		scoredPoint.newPointScored(game.getPointTypes().get(pointTypeIndex), scoringTeam);
		pointsScored.add(scoredPoint);
		if (alliance == "red"){
			redAllianceScore = redAllianceScore + ((Point)game.getPointTypes().toArray()[pointTypeIndex]).getPointValue();
		}
		else{
			blueAllianceScore = blueAllianceScore + ((Point)game.getPointTypes().toArray()[pointTypeIndex]).getPointValue();
		}
	}
	
	public void penalty(String penaltyDescription, int penaltyValue, int penalizedTeam, String allianceEffected){
		//Point newPenalty = new Point((Point)game.pointTypes.toArray()[pointTypeIndex], penalizedTeam);
		Point penalty = new Point();
		penalty.setPointType(penaltyDescription, "penalties", penaltyValue);
		penalties.add(penalty);
		if (allianceEffected == "red"){
			redAllianceScore = redAllianceScore - penaltyValue;
		}
		else{
			blueAllianceScore = blueAllianceScore - penaltyValue;
		}
	}
	
	public ArrayList<Point> getPointsScored(){
		return pointsScored;
	}
	public ArrayList<Point> getPenalties(){
		return penalties;
	}	
	public int getRedAllianceScore(){
		return redAllianceScore;
	}
	public int getBlueAllianceScore(){
		return blueAllianceScore;
	}
	public String getGameComment(){
		return gameComment;
	}

}