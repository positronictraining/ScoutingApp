package io.github.positronictraining.scouting486;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


@SuppressWarnings("restriction") //to get rid of annoying and useless error signs
public class XmlTranslator {
	
	//VARIABLES
	ArrayList<String> fileList = new ArrayList<String>();
	
	//METHODS
	public void writeGameData(Game game, File file){//Writes any given game data to an XML file
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);	//creates a new instance of JAXBContext for Game class
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		//creates an XML writer for Game class file
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //sets system output preferences
			jaxbMarshaller.marshal(game,file);			//writes specified game properties to XML file
			jaxbMarshaller.marshal(game,System.out);	//outputs XML text that would go in XML file to console
		} catch (JAXBException e){
			e.printStackTrace();	//shows errors if something goes wrong
		}
	}
	
	public Game readGameData(File file){ //Reads all the game data from any given XML file
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class); //creates a new instance of JAXBContext for the class Game
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //creates an XML reader for a file Game class data
			Game readGame = (Game) jaxbUnmarshaller.unmarshal(file); //reads a specified file
			return readGame; //returns result
		}catch (JAXBException e){
			e.printStackTrace(); //shows errors if something goes wrong
			return null; //returns null so that code runs
		}
	}
	
	public String[] getCompetitionNames(File file){ //Reads any file containing Game class data and returns all competition names
		ArrayList<Competition> competitionList = this.readGameData(file).getCompetitions(); //uses readGameData to get competition List
		ArrayList<String> competitionNameList = new ArrayList<String>(); //Creates an append-able list to record found game names
		for (int i=0; i<competitionList.size(); i++){ //finds all competition names and appends them to competitionNameList
			competitionNameList.add(competitionList.get(i).competitionName);
		}
		return (String[]) competitionNameList.toArray(); //returns the result
	}
	
	public void writeFileDirectory(FileSecretary fileSecretary, File fileSecretaryDirectory){ //Writes specified FileSecretary data to any given file
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(FileSecretary.class); //runs through same method as previous write method for Game data
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(fileSecretary, fileSecretaryDirectory);
		}catch (JAXBException e){
			e.printStackTrace();
		}
	}
	
	public FileSecretary readFileDirectory(File fileSecretaryDirectory){ //Reads specified FileSecretary data from any given file
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(FileSecretary.class); //runs through same method as previous read method for Game data
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FileSecretary readFile = (FileSecretary) jaxbUnmarshaller.unmarshal(fileSecretaryDirectory);
			return readFile;
		}catch (JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
}
