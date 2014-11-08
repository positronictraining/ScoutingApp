package io.github.positronictraining.scouting486;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializationComm implements Serializable {
	
	private ArrayList<String> gameFileDirectories = new ArrayList<String>();
	
	// File libraryFile = new File("/scouting486/ScoutingData/libraryfile.ser");
	private File libraryFile = new File("ScoutingData/libraryfile.ser");
	private Library library;
	private ArrayList games;
	
	public SerializationComm() {
		new File("ScoutingData/").mkdirs();
		try {
			libraryFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getGameFileDirectories() {	
		return gameFileDirectories;
	}
	
	public void newGameFile(String gameName) {
		// File newFile =  new File("/scouting486/ScoutingData/"+gameName+".ser");
		File newFile =  new File("ScoutingData/"+gameName+".ser");
		new File("ScoutingData/").mkdirs();
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameFileDirectories.add(newFile.getAbsolutePath());
		System.out.println("Added game file: " + newFile.getAbsolutePath());
	}
	
	public String findGameFileDirectory(String gameName) {
		for (String directory:gameFileDirectories){
			if(directory.contains(gameName)){
				System.out.println("Game directory found! (" + directory + ")");
				return directory;
			}
		}
		return null;	
	}
	
	public void writeGame(Game game) {
		
		this.newGameFile(game.gameName);
		getLibrary().addGame(game);
		writeLibrary();
		try{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.findGameFileDirectory(game.gameName)));
			objectOutputStream.writeObject(game);
			System.out.println("game has been told to write to "+this.findGameFileDirectory(game.gameName));
			objectOutputStream.close();
			
		} catch(IOException exception){

			exception.printStackTrace();
			
		}
		
	}
	
	public boolean writeGameIfNotExists(Game game) {
		if (getLibrary().gameExists(game)) {
			return false;
		} else {
			writeGame(game);
			return true;
		}
	}
	
	public Game readGame(String filepath) throws ClassNotFoundException {
		
		try{
			
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath));
			Game game = (Game) objectInputStream.readObject();
			System.out.println("program told to read game at file path "+filepath);
			objectInputStream.close();
			return game;
		
		} catch(IOException exception){
			
			exception.printStackTrace();
			return null;
		}
	}
	
	public void writeLibrary() {

		try{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(libraryFile.getAbsolutePath()));
			objectOutputStream.writeObject(library);
			System.out.println("library has been has been told to write to "+libraryFile.getAbsolutePath());
			objectOutputStream.close();

		} catch(IOException exception){

			exception.printStackTrace();		
		}
	}
	
	public void readLibrary() {
		
		try{
			
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(libraryFile.getAbsolutePath()));
			Library readLibrary = (Library) objectInputStream.readObject();
			objectInputStream.close();
			setLibrary(readLibrary);
			
		} catch(ClassNotFoundException exception) {
			System.out.println("Library not found in file. Writing new one...");
			library = new Library();
			writeLibrary();
		} catch(EOFException exception) {
			System.out.println("Library not found in file. Writing new one...");
			library = new Library();
			writeLibrary();
		} catch(IOException exception){
			
			exception.printStackTrace();

		}
		
	}
	public void setLibrary(Library lib) {
		library = lib;
	}
	public Library getLibrary() {
		if (library == null) {
			readLibrary();
		}
		return library;
	}
	
}
