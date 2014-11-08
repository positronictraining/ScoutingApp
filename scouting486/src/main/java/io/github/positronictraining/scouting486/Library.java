package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	private SerializationComm serialcomm =  new SerializationComm();
	
	private ArrayList<Game> gameList = new ArrayList<Game>();
	
	public Library(){

		serialcomm.writeLibrary(this);
		
	}
	
	public void addGame(){
		
		
		
	}
	
	public ArrayList<Game> getGameList(){
		return gameList;
	}

}
