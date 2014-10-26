package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction") //gets rid of innacurate and annoying error signals
@XmlRootElement
public class FileSecretary {
	@XmlElement
	public ArrayList<String> fileList = new ArrayList<String>(); //makes and XML readable and writable variable called fileList
}
