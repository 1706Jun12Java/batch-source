package com.revature.io;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BearHandler extends DefaultHandler {

	public BearHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes)
	throws SAXException {
		System.out.println(qName+": ");
	}
	@Override
	public void endElement(String uri, String localname, String qName)
	throws SAXException {
		System.out.println("// "+qName);
	}
	
	/* What we're doing when we encounter the contents of an element*/
	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch,start,length));
	}

}
