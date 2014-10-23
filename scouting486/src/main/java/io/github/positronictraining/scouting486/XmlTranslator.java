package io.github.positronictraining.scouting486;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlTranslator {
	
	ArrayList<File> fileList = new ArrayList<File>();
	
	public void writeGameData(Game game, File file){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(game,file);
			jaxbMarshaller.marshal(game,System.out);
		} catch (JAXBException e){
			e.printStackTrace();
		}
	}
	public Game readGameData(File file){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Game readGame = (Game) jaxbUnmarshaller.unmarshal(file);
			return readGame;
		}catch (JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
	public String[] getCompetitionNames(File file){
		ArrayList<Competition> competitionList = this.readGameData(file).getCompetitions();
		ArrayList<String> competitionNameList = new ArrayList<String>();
		for (int i=0; i<competitionList.size(); i++){
			competitionNameList.add(competitionList.get(i).competitionName);
		}
		return (String[]) competitionNameList.toArray();
	}
	
	public void writeFileDirectory(File file, File fileDirectory){
		try{
			this.fileList.add(file);
			JAXBContext jaxbContext = JAXBContext.newInstance();
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(file, fileDirectory);
		}catch (JAXBException e){
			e.printStackTrace();
		}
	}
	public File readFileDirectory(File fileDirectory){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(File.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			File readFile = (File) jaxbUnmarshaller.unmarshal(fileDirectory);
			return readFile;
		}catch (JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
}
