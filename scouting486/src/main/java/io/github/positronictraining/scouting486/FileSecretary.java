package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileSecretary {
	@XmlElement
	public ArrayList<String> fileList = new ArrayList<String>();
}
