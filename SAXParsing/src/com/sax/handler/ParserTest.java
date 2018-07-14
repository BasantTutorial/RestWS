package com.sax.handler;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserTest {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		ParseHandler parseHandler = new ParseHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(
				"E:\\RestWS\\SAXParsing\\resource\\purchaseOrder.xml"),
				parseHandler);
	}
}
