package com.bharath.xmlparsers.sax;

import java.util.jar.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bharath.xmlparsers.dto.DriversLicense;

public class SAXHandler extends DefaultHandler {

	private DriversLicense driversLicense;
	private String content;
	

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("DriversLicense")) {
			driversLicense = new DriversLicense();		
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		driversLicense = new DriversLicense();

		switch (qName) {
		case "Number":
			driversLicense.setNumber(Long.parseLong(content));

		case "FirstName":
			driversLicense.setFirstName(content);

		case "LastName":
			driversLicense.setLastName(content);
			break;

		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

	public DriversLicense getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(DriversLicense driversLicense) {
		this.driversLicense = driversLicense;
	}

}
