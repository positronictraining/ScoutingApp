package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	private SerializationComm serialcomm =  new SerializationComm();
	
	private ArrayList<Game> gameList = new ArrayList<Game>();
	
	
	public void addGame(Game g){
		gameList.add(g);
	}
	
	public ArrayList<Game> getGameList(){
		return gameList;
	}

}
