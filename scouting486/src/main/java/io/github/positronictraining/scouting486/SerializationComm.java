package io.github.positronictraining.scouting486;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;



public class SerializationComm implements Serializable{
	
	private ArrayList<String> gameFileDirectories = new ArrayList<String>();
	private ArrayList<Game> games = new ArrayList<Game>();
	
	public ArrayList<String> getGameFileDirectories(){	
		return gameFileDirectories;
	}
	
	public void newGameFile(String gameName){
		
		File newFile =  new File("/scouting486/ScoutingData/"+gameName+".ser");
		gameFileDirectories.add(newFile.getAbsolutePath());
	}
	
	public String findGameFileDirectory(String gameName){
		
		String desiredDirectory = null;
		
		for (int i = 0; i < gameFileDirectories.size(); i++){
			
			String directory = gameFileDirectories.get(i);
			if(directory.contains(gameName)){
				desiredDirectory = directory;			
			}
		}
		
		return desiredDirectory;	
	}
	
	public void writeGame(Game game){
		
		this.newGameFile(game.gameName);
		
		try{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.findGameFileDirectory(game.gameName)));
			objectOutputStream.writeObject(game);
			System.out.println("game has been told to write to"+this.findGameFileDirectory(game.gameName));

		} catch(IOException exception){

			exception.printStackTrace();		
		}
	}
	
	public void writeLibrary()){
		File newFile = new File("/scouting486/ScoutingData/libraryfile.ser");
		try{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(newFile.getAbsolutePath()));
			objectOutputStream.writeObject(object);
			System.out.println("object has been has been told to write to"+newFile.getAbsolutePath());

		} catch(IOException exception){

			exception.printStackTrace();		
		}
	}
	
	public Game readGame(String filepath) throws ClassNotFoundException{
		
		try{
			
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("filepath"));
			Game game = (Game) objectInputStream.readObject();
			System.out.println("program told to read game at file path"+filepath);
			return game;
		
		} catch(IOException exception){
			
			exception.printStackTrace();
			return null;
		}
	}

	public void addNewGame;(){
		
	}
}
