package io.github.positronictraining.scouting486;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlTranslator {
	
	ArrayList<String> fileList = new ArrayList<String>();
	
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
	
	public void writeFileDirectory(FileSecretary fileSecretary, File fileSecretaryDirectory){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(FileSecretary.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(fileSecretary, fileSecretaryDirectory);
		}catch (JAXBException e){
			e.printStackTrace();
		}
	}
	public FileSecretary readFileDirectory(File fileSecretaryDirectory){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(FileSecretary.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FileSecretary readFile = (FileSecretary) jaxbUnmarshaller.unmarshal(fileSecretaryDirectory);
			return readFile;
		}catch (JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
}
