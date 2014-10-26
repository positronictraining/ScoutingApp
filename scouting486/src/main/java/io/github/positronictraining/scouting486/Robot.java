package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction") //suppresses warnings to get rid on nonexistent error messages
@XmlRootElement
public class Robot {
	@XmlElement
	int teamNumber; //creates an XML read-and-writable variable called teamNumber for the robot
	@XmlElement
	String playerType; //creates an XML read-and-writable variable called playerType for the robot
	@XmlElement
	ArrayList<Point> pointsScored = new ArrayList<Point>(); //creates an XML read-and-writable variable called pointsScored for the robot
	@XmlElement
	ArrayList<Point> penaltiesEarned = new ArrayList<Point>(); //creates an XML read-and-writable variable called penalties earned for the robot
}