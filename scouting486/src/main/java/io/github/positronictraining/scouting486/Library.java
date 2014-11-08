package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	private SerializationComm serialcomm =  new SerializationComm();
	
	private ArrayList<Game> gameList = new ArrayList<Game>();
	
	
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

}
