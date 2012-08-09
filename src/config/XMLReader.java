package config;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class XMLReader {
	
	static ArrayList<CEP> cepArrayList;

	public static void main(String args[]) {
		importXML("/home/mohammadsalim/Desktop/conf.xml");
	}
	
	public static ArrayList<CEP> getCepArrayList() {
		return cepArrayList;
	}

	public static void importXML(String file) {

		cepArrayList = new ArrayList<CEP>();
		try {

			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			dbFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Node ceps = doc.getChildNodes().item(0);
			NodeList cepList = ceps.getChildNodes();
			for (int i = 0; i < cepList.getLength(); i++) {
				Node cepNode = cepList.item(i);
				if (!cepNode.getNodeName().equals("CEP"))
					continue;
				// else
				// cep[i].setName( ((Element) cepNode).getAttribute("name"));
				CEP cep = new CEP(((Element) cepNode).getAttribute("name"));
				NodeList eventList = cepNode.getChildNodes().item(0)
						.getChildNodes();
				for (int j = 0; j < eventList.getLength(); j++)
					// System.out.println((
					// (Element)eventList.item(j)).getAttribute("type"));
					cep.addEvent(((Element) eventList.item(j))
							.getAttribute("type"));
				System.out.println("String found " + cep.getName());

				NodeList ruleList = cepNode.getChildNodes().item(1)
						.getChildNodes();
				for (int j = 0; j < ruleList.getLength(); j++) {
					cep.addRule(((Element) ruleList.item(j))
							.getAttribute("type"));
					int index = cep.rules.size() - 1;
					NodeList listenerList = ruleList.item(j).getChildNodes();
					for (int k = 0; k < listenerList.getLength(); k++) {
						cep.rules.get(index).addListener(
								listenerList.item(k).getTextContent());
					}

				}
				cepArrayList.add(cep);
				//System.out.println(cep);
			}
			//
		} catch (NullPointerException e) {
			System.out.println("Object not found");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}