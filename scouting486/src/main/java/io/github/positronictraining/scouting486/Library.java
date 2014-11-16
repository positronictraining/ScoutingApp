package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	private SerializationComm serialcomm =  new SerializationComm();
	
	private ArrayList<Game> gameList = new ArrayList<Game>();
	
	private int selectedCompetition;
	private int selectedGame;
	private boolean gameSelected = false;
	private boolean competitionSelected = true;
	
	public void addGame(Game g){
		gameList.add(g);
		System.out.println("Added new game \"" + g.gameName + "\"");
	}
	
	public void addGameIfNotExists(Game g) {
		if (!gameExists(g)) {
			addGame(g);
		}
	}
	
	public boolean gameExists(Game g) {
		for (Game game:gameList) {
			if (game.matches(g)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Game> getGameList(){
		return gameList;
	}

	public Game[] getGameArray(){
		return gameList.toArray(new Game[gameList.size()]);
	}
	
	public void setSelectedGame(Game g) {
		selectedGame = gameList.indexOf(g);
		gameSelected = true;
	}
	
	public Game getSelectedGame() {
		return gameList.get(selectedGame);
	}
	public Competition getSelectedCompetition() {
		return getSelectedGame().getCompetitions().get(selectedCompetition);
	}
	public void setSelectedCompetition(Competition c) {
		selectedCompetition = gameList.indexOf(c);
		competitionSelected = true;
	}
	public boolean gameSelected() {
		return gameSelected;
	}
	public boolean competitionSelected() {
		return competitionSelected;
	}
}
