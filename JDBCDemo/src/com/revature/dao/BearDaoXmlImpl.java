package com.revature.dao;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.revature.domain.Bear;
import com.revature.io.BearHandler;

public class BearDaoXmlImpl implements BearDao {
	
	private String docLocation;

	public BearDaoXmlImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public BearDaoXmlImpl(String docLocation) {
		this();
		this.docLocation = docLocation;
	}

	@Override
	public List<Bear> getBears() {
		//readBearsDOM(docLocation);
		readBearsSAX(docLocation);
		return null;//you'd want to grab details of bears, etc and put them in objects
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createBear(Bear bear) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int feedBear(int bearId, int hiveId, int amt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void readBearsDOM (String filename){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filename);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList bearList = doc.getElementsByTagName("bear");
			for (int i=0; i<bearList.getLength(); i++){
				Node bear = bearList.item(i);
				System.out.println("\t"+bear.getNodeName());
				NodeList children = bear.getChildNodes();
				for (int j=0; j<children.getLength();j++){
					Node child = children.item(j);
					if(child.getNodeType()==Node.ELEMENT_NODE) {
						System.out.println("\t\t"+child.getNodeName()+" : "+child.getTextContent());
					}else {
						System.out.println("\t\t"+child.getNodeName());
						NodeList grandchildren = child.getChildNodes();
						for(int k=0; k<grandchildren.getLength();k++){
							Node grandchild = grandchildren.item(j);
							if(grandchild.getNodeType()==Node.ELEMENT_NODE) {
								System.out.println("\t\t"+grandchild.getNodeName()+" : "+grandchild.getTextContent());
							}
						}
					}
					
				}
			}
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void readBearsSAX (String filename){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = factory.newSAXParser();
			BearHandler handler = new BearHandler();
			saxParser.parse(filename, handler);
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
