package io.github.positronictraining.scouting486;

public class Scouting486 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu mainMenu = new MainMenu();
		XmlTranslator xmlTranslator = new XmlTranslator();
		Game aerialAssist = new Game();
		aerialAssist.year = 2014;
		aerialAssist.gameName = "Aerial Assist";
		aerialAssist.addNewPointType("Autonomous High Goal Lighted", "Autonomous", 15);
		aerialAssist.addNewCompetition("Hatsboro Horsham");
		aerialAssist.getCompetitions().get(0).addMatch(1, 2, 3, 4, 5, 6);
		aerialAssist.getCompetitions().get(0).getMatches().get(0).pointScored(aerialAssist, 0, 1, "red");
		aerialAssist.getCompetitions().get(0).addRobot(1);
		xmlTranslator.writeGameData(aerialAssist);
	}
}