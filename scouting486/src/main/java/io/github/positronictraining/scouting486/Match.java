package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction") //suppresses unwanted and inaccurate warning messages
@XmlRootElement
public class Match {
	
	//VARIABLES
	@XmlElement
	public int[] blueAlliance = new int[3]; //creates an XML read-and-writable variable called blueAlliance for the match
	@XmlElement
	public int[] redAlliance = new int[3];  //creates an XML read-and-writable variable called redAlliance for the match
	@XmlElement
	private int blueAllianceScore;  //creates an XML read-and-writable variable called blueAllianceScore for the match
	@XmlElement
	private int redAllianceScore; //creates an XML read-and-writable variable called redAllianceScore for the match
	@XmlElement
	private String gameComment; //creates an XML read-and-writable variable called game comment for the match
	@XmlElement
	private ArrayList<Point> pointsScored = new ArrayList<Point>(); //creates an XML read-and-writable variable called pointsScored for the match
	@XmlElement
	private ArrayList<Point> penalties = new ArrayList<Point>(); //creates an XML read-and-writable variable called penalties for the match
	
	//METHODS
	public void setRedAndBlueAlliances(int red1, int red2, int red3, int blue1, int blue2, int blue3){ //sets matches for the team
		this.redAlliance[0] = red1;
		this.redAlliance[1] = red2;
		this.redAlliance[2] = red3;
		this.blueAlliance[0] = blue1;
		this.blueAlliance[1] = blue2;
		this.blueAlliance[2] = blue3;
	}
	
	public void pointScored(Game game, int pointTypeIndex, int scoringTeam, String alliance){ //adds a new score given certain values and adjusts the present score of the match
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
	
	public void penalty(String penaltyDescription, int penaltyValue, int penalizedTeam, String allianceEffected){ //adds a new penalty given certain values and adjusts the final score of the match
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