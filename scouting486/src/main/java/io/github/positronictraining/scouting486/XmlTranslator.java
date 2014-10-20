package io.github.positronictraining.scouting486;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlTranslator {
	

	
	public void writeGameData(Game game, String filePath){
		try{
			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(game,file);
			jaxbMarshaller.marshal(game,System.out);
		} catch (JAXBException e){
			e.printStackTrace();
		}
	}
	public Game readGameData(String filePath){
		try{
			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Game readGame = (Game) jaxbUnmarshaller.unmarshal(file);
			return readGame;
		}catch (JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
}
