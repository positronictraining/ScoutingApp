package io.github.positronictraining.scouting486;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Scouting486 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		MainMenu mainMenu = new MainMenu();
		
		FileInputStream fileInputStream = new FileInputStream("/scouting486/ScoutingData/ScoutingData.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Game aerialAssist = (Game) objectInputStream.readObject();
		
		objectInputStream.close();
		
	}
}