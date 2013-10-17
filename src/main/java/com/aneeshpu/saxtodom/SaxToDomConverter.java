package com.aneeshpu.saxtodom;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class SaxToDomConverter
{
    public static void main( String[] args ) throws SAXException, ParserConfigurationException, IOException {
        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        final SAXParser saxParser = saxParserFactory.newSAXParser();
        final XMLReader xmlReader = saxParser.getXMLReader();
        final ParentBasedContentHandler parentBasedContentHandler = new ParentBasedContentHandler();
        xmlReader.setContentHandler(parentBasedContentHandler);
        getFile();
        xmlReader.parse(getFile());

        print(parentBasedContentHandler.currentNode());

    }

    private static void print(final Node node) {
        System.out.println(node.toString());
    }

    private static InputSource getFile() throws FileNotFoundException {
        final URL resource = SaxToDomConverter.class.getResource("/sample.xml");
        System.out.println(resource.getFile());
        return new InputSource(new FileInputStream(resource.getFile()));
    }
}