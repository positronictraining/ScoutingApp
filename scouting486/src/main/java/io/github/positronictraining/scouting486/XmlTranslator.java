package io.github.positronictraining.scouting486;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlTranslator {
	
	public void xmlTest(){
		Point testPoint = new Point();
		testPoint.setPointType("test name", "test period", 0);
		try{
			File file = new File("ScoutingData/scoutingDataTest.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Point.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(testPoint,file);
			jaxbMarshaller.marshal(testPoint,System.out);
		} catch (JAXBException e){
			e.printStackTrace();
		}	
	}
	
	public void writeGameData(Game game){
		try{
			File file = new File("ScoutingData/scoutingData.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(game,file);
			jaxbMarshaller.marshal(game,System.out);
		} catch (JAXBException e){
			e.printStackTrace();
		}
	}
	
	public void writePointData(Point point){
		
	}
}
