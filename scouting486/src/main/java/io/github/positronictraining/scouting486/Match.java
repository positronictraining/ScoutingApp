package io.github.positronictraining.scouting486;

import java.io.*;
import java.util.ArrayList;


public class Match implements Serializable{
	
	//VARIABLES
	public String[] blueAlliance = new String[3];
	public String[] redAlliance = new String[3];
	private int blueAllianceScore;
	private int redAllianceScore;
	private String gameComment;
	private ArrayList<Point> pointsScored = new ArrayList<Point>();
	private ArrayList<Point> penalties = new ArrayList<Point>();
	public boolean redWon = false;
	public boolean blueWon = false;
	
	//METHODS
	public void setRedAndBlueAlliances(String red1, String red2, String red3, String blue1, String blue2, String blue3){ //sets matches for the team
		this.redAlliance[0] = red1;
		this.redAlliance[1] = red2;
		this.redAlliance[2] = red3;
		this.blueAlliance[0] = blue1;
		this.blueAlliance[1] = blue2;
		this.blueAlliance[2] = blue3;
	}
	
	public void pointScored(Game game, int pointTypeIndex, String scoringTeam, String alliance){ //adds a new score given certain values and adjusts the present score of the match
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
	
	public void gameEnd(){
		
		if (redAllianceScore > blueAllianceScore ){
			redWon = true;
		}else{
			blueWon = true;
		}
	}
	
	public void penalty(String penaltyDescription, int penaltyValue, String team, String allianceEffected){ //adds a new penalty given certain values and adjusts the final score of the match
		//Point newPenalty = new Point((Point)game.pointTypes.toArray()[pointTypeIndex], penalizedTeam);
		Point penalty = new Point();
		penalty.setPointType(penaltyDescription, "penalties", penaltyValue);
		penalty.setScoringTeam(team);
		penalty.setPointValue(penaltyValue);
		penalties.add(penalty);
		if (allianceEffected == "red"){
			redAllianceScore = redAllianceScore - penaltyValue;
		}
		else{
			blueAllianceScore = blueAllianceScore - penaltyValue;
		}
	}
	
	public ArrayList<Point> getPointsScored(){ //getter for pointsScored since pointsScored is private
		return pointsScored;
	}
	public ArrayList<Point> getPenalties(){ //getter for penalties since penalties is private
		return penalties;
	}	
	public int getRedAllianceScore(){ //getter for redAllianceScore since redAllianceScore is private
		return redAllianceScore;
	}
	public int getBlueAllianceScore(){ //getter for blueAllianceScore since blueAllianceScore is private
		return blueAllianceScore;
	}
	public String getGameComment(){	//getter for gameComment since gameComment is private
		return gameComment;
	}
}