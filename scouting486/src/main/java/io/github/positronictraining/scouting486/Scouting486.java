package io.github.positronictraining.scouting486;

import java.io.File;

public class Scouting486 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CLASSES TO BE USED
		MainMenu mainMenu = new MainMenu();
		XmlTranslator xmlTranslator = new XmlTranslator();
		FileSecretary fileSecretary = new FileSecretary();
		Game aerialAssist = new Game();
		
		//AERIAL ASSIST EXAMPLE CODE
		aerialAssist.year = 2014;
		aerialAssist.gameName = "Aerial Assist";
		aerialAssist.addNewPointType("Autonomous High Goal Lighted", "Autonomous", 15);
		aerialAssist.addNewCompetition("Hatsboro Horsham");
		aerialAssist.getCompetitions().get(0).addMatch(1, 2, 3, 4, 5, 6);
		aerialAssist.getCompetitions().get(0).getMatches().get(0).pointScored(aerialAssist, 0, 1, "red");
		aerialAssist.getCompetitions().get(0).addRobot(1);
		xmlTranslator.writeGameData(aerialAssist, fileSecretary.gameFile);
		System.out.println(xmlTranslator.readGameData(fileSecretary.gameFile).gameName);
	}
}