package io.github.positronictraining.scouting486;

import java.io.*;
import java.util.ArrayList;

public class Robot implements Serializable{
	
	int teamNumber;
	String playerType;
	ArrayList<Point> pointsScored = new ArrayList<Point>();
	ArrayList<Point> penaltiesEarned = new ArrayList<Point>();

}