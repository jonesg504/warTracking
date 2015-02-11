package warTracking;

//Class that will represent a system file name

import java.io.File;

//Used to write data to a file

import java.io.FileOutputStream;

//Triggered when an I/O error occurs

import java.io.IOException;

//Represents your XML document and contains useful methods

import java.util.ArrayList;

import org.jdom2.Document;

//Represents XML elements and contains useful methods

import org.jdom2.Element;

//Top level JDOM exception

import org.jdom2.JDOMException;

//Represents text used with JDOM

import org.jdom2.Text;

//Creates a JDOM document parsed using SAX Simple API for XML

import org.jdom2.input.SAXBuilder;

//Formats how the XML document will look

import org.jdom2.output.Format;

//Outputs the JDOM document to a file

import org.jdom2.output.XMLOutputter;

public class test {
	public static void writeClan(Clan clan, war editWar, war addWar, int numWars) {
		writeXML(clan, editWar, addWar, numWars);
	}

	private static void readXML() {

		SAXBuilder builder = new SAXBuilder();
		try {

			// Parses the file supplied into a JDOM document

			Document readDoc = builder.build(new File(".save.xml"));

			// Returns the root element for the document

			System.out.println("Root: " + readDoc.getRootElement());

			// Gets the text found between the name tags

			System.out.println("Show: "
					+ readDoc.getRootElement().getChild("show")
							.getChildText("name"));

			// Gets the attribute value for show_id assigned to name

			System.out.println("Show ID: "
					+ readDoc.getRootElement().getChild("show")
							.getChild("name").getAttributeValue("show_id")
					+ "\n");

			Element root = readDoc.getRootElement();

			// Cycles through all of the children in show and prints them

			for (Element curEle : root.getChildren("show")) {
				System.out.println("Show Name: " + curEle.getChildText("name"));
				System.out.println("Show ID: "
						+ curEle.getChild("name").getAttributeValue("show_id"));
				System.out.print("On " + curEle.getChildText("network")
						+ " in the ");
				System.out.println(curEle.getChild("network")
						.getAttributeValue("country") + "\n");
			}

		}

		catch (JDOMException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeXML(Clan clan, war editWar, war addWar, int warNumber ){
	try{
		ArrayList<war> warsNow = new ArrayList<war>();
		XMLParser parse = new XMLParser();
		Document doc = new Document();
		Element theRoot = new Element("clan");
		doc.setRootElement(theRoot);
		Element members = new Element("members");
		Element wars = new Element("wars");
		Element warPart = new Element("numWars");
		warPart.addContent("" + warNumber);
		wars.addContent(warPart);
		for(Object o : clan) {
			Player play = (Player)o;
			Element member = new Element("member");
			Element name = new Element("name");
			name.addContent(play.getName());
			Element thLevel = new Element("thLevel");
			thLevel.addContent("" + play.getThLevel());
			Element baseRank = new Element("baseRank");
			baseRank.addContent("" + play.getRank());
			Element rank = new Element("rank");
			rank.addContent("" + play.getWorth());
			Element numWars = new Element("wars");	
			numWars.addContent("" + play.getNumWars());
			member.addContent(name);
			member.addContent(thLevel);
			member.addContent(baseRank);
			member.addContent(rank);
			member.addContent(numWars);
			members.addContent(member);
		}
		theRoot.addContent(members);
		int i = 0;
		for(int num = 0; num < parse.numWars(); num++) {
			war currWar = parse.loadWar(num);
			warsNow.add(currWar);
		}
		warsNow.add(editWar);
		if (addWar != null) {
			warsNow.add(addWar);
		}
		
		for(war currWar : warsNow) {
			currWar.updateStars();
			Element warNum = new Element("war" + i);
			Element attacks = new Element("attacks");
			Element participants = new Element("Participants");
			Element defends = new Element("defenses");
			int aNum = 1;
			for(Object o : currWar) {
				Player play = (Player) o;
				Player playa = clan.getPlayer(play.getName());
				if (playa != null) {
					play.setRank(playa.getRank());
				}
					Element member = new Element("member");
					Element partName = new Element("name");
					partName.addContent(play.getName());
					Element attacksU = new Element("AttacksUsed");
					attacksU.addContent("" + play.getAttackU());
					Element attacksW = new Element("AttacksWon");
					attacksW.addContent("" + play.getAttackW());
					Element totalStars = new Element("Stars");
					totalStars.addContent("" + play.getStars());
					
				
					participants.addContent(member);
					member.addContent(partName);
					member.addContent(attacksU);
					member.addContent(attacksW);
					member.addContent(totalStars);
					
					
				
			}
			ArrayList<Attack> atts = currWar.getAttacks();
			for(Attack at : atts) {
				Element attackNum = new Element("attack" + aNum);
				Element name = new Element("name");
				name.addContent(at.getPlayer());
				Element thLevel = new Element("thLevel");
				thLevel.addContent("" + at.getThLevel());
				Element baseRank = new Element("baserank");
				baseRank.addContent("" + at.getBaseRank());
				Element starsGained = new Element("starsGained");
				starsGained.addContent("" + at.getStars());
				Element star3 = new Element("star3");
				star3.addContent("" + at.isStar3());
				aNum++;
				attackNum.addContent(name);
				attackNum.addContent(thLevel);
				attackNum.addContent(baseRank);
				attackNum.addContent(starsGained);
				attackNum.addContent(star3);
				attacks.addContent(attackNum);
			}
			int dNum = 0;
			ArrayList<Defense> defs = currWar.getDefends();
			for(Defense def : defs) {
				Element defNum = new Element("defense" + dNum);
				Element name = new Element("name");
				name.addContent(def.getPlayer());
				Element thLevel = new Element("thLevel");
				thLevel.addContent("" + def.getThLevel());
				Element starsGained = new Element("starsGained");
				starsGained.addContent("" + def.getStars());
				dNum++;
				defNum.addContent(name);
				defNum.addContent(thLevel);
				defNum.addContent(starsGained);
				defends.addContent(defNum);
			}
			warNum.addContent(participants);
			warNum.addContent(attacks);
			warNum.addContent(defends);
			
			wars.addContent(warNum);
			i++;
		}

		
		theRoot.addContent(wars);
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileOutputStream(new File("./save.xml")));
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

/*
 * Installing JDOM
 * 
 * Download jdom.jar https://github.com/hunterhacker/jdom/downloads Download
 * jdom-2.0.2.zip
 * 
 * Right click default eclipse directory - Build Path
 * 
 * Click Java Build Path
 * 
 * Click Libraries tab - external libraries
 * 
 * Add the JDOM libraries
 */