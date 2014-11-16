package io.github.positronictraining.scouting486;

import java.io.*;
import java.util.ArrayList;

public class Robot implements Serializable{
	
	int numberOfTeamTraits = 4; //need this for data table
	String teamNumber;
	String playerType;
	ArrayList<Point> pointsScored = new ArrayList<Point>();
	ArrayList<Point> penaltiesEarned = new ArrayList<Point>();

}