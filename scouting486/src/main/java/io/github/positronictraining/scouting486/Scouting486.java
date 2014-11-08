package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Scouting486 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		MainMenu mainMenu = new MainMenu();
		SerializationComm serialcomm = new SerializationComm();
		Library library = new library();
		
		serai
		
		Game aerialAssist = new Game();
 		aerialAssist.year = 2014;
 		aerialAssist.gameName = "Aerial Assist";
 		aerialAssist.addNewPointType("Autonomous High Goal Lighted", "Autonomous", 15);
 		aerialAssist.addNewCompetition("Hatsboro Horsham");
 		aerialAssist.getCompetitions().get(0).addMatch(1, 2, 3, 4, 5, 6);
 		aerialAssist.getCompetitions().get(0).getMatches().get(0).pointScored(aerialAssist, 0, 1, "red");
		aerialAssist.getCompetitions().get(0).addRobot(1);
		
		serialcomm.newGameFile(aerialAssist.gameName);
		serialcomm.writeGame(aerialAssist);	
	}
	
	private boolean initiate(){
		return true;
	}
}