package data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class haendler {
	private ArrayList<auto> autoliste;
	private String name;
	private String adr;
	private String telnum;
	
	@XmlElementWrapper(name = "autoliste")
	@XmlElement(name = "auto")
	public ArrayList<auto> getAutoliste() {
		return autoliste;
	}
	public void setAutoliste(ArrayList<auto> autoliste) {
		this.autoliste = autoliste;
	}
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute(name = "adr")
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	@XmlAttribute(name = "telnum")
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}	
}
