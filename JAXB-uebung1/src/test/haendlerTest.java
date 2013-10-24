package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import data.*;

public class haendlerTest {
	
	private static final String SERVER_XML ="./server-jaxb.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<auto> autoliste1 = new ArrayList<auto>();
		
		//Klasse hätte ich groß schreiben sollen >.<
		auto auto1 = new auto();
		auto1.setMarke("VW");
		auto1.setHersteller("VW");
		auto1.setFarbe("Blau");
		auto1.setModell("Cabrio");
		auto1.setWert("30000");
		
		auto auto2 = new auto();
		auto2.setMarke("Ferrari");
		auto2.setHersteller("Ferrari");
		auto2.setFarbe("Rot");
		auto2.setModell("Sport");
		auto2.setWert("75000");
		
		autoliste1.add(auto1);
		autoliste1.add(auto2);
		
		haendler schnoesel = new haendler();
		schnoesel.setName("Schnosel & Co");
		schnoesel.setAdr("schnoeselgasse 10");
		schnoesel.setTelnum("0676 schnoesel5");
		schnoesel.setAutoliste(autoliste1);
		
		JAXBContext context = JAXBContext.newInstance(haendler.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		//Write to System.out
		System.out.println("XML-Version");
		System.out.println();
		m.marshal(schnoesel, System.out);
		
		//Write to File
		m.marshal(schnoesel, new File(SERVER_XML));
		
		//get variable from the xml file, created in the lines above
		System.out.println();
		System.out.println("Ergebnis (Daten) aus der XML-Version");
		Unmarshaller um = context.createUnmarshaller();
		haendler schnoesel2 = (haendler)um.unmarshal(new FileReader(SERVER_XML));
		ArrayList<auto> list = schnoesel2.getAutoliste();
		for(auto a:list){
			System.out.println();
			System.out.println(a.getMarke()+" aus "+schnoesel2.getName() + a.getModell() + " " + a.getFarbe() + " " + a.getWert() + "\n\rhergestellt von: "+a.getHersteller());
		}
	}

}
