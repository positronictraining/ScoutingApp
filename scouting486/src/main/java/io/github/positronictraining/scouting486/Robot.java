package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Robot {
	@XmlElement
	int teamNumber;
	@XmlElement
	String playerType;
	@XmlElement
	ArrayList<Point> pointsScored = new ArrayList<Point>();
	@XmlElement
	ArrayList<Point> penaltiesEarned = new ArrayList<Point>();	
}