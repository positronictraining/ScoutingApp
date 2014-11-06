package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Scouting486 {
	public static void main(String[] args) throws IOException {
		
		MainMenu mainMenu = new MainMenu();
		
		FileOutputStream fileStream = new FileOutputStream("/Users/Daniel/Documents/Robotics/2014-2015 Season/ScoutingApp/scouting486/ScoutingData/ScoutingData.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
		
		Game aerialAssist = new Game();
		
		aerialAssist.year = 2014;
		aerialAssist.gameName = "Aerial Assist";
		aerialAssist.addNewPointType("Autonomous High Goal Lighted", "Autonomous", 15);
		aerialAssist.addNewCompetition("Hatsboro Horsham");
		aerialAssist.getCompetitions().get(0).addMatch(1, 2, 3, 4, 5, 6);
		aerialAssist.getCompetitions().get(0).getMatches().get(0).pointScored(aerialAssist, 0, 1, "red");
		
		outputStream.writeObject(aerialAssist);
		
		outputStream.close();
		
	}
}