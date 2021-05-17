package com.solvd.connectionPool.utils;

import com.solvd.connectionPool.pool.App;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParser {
    private static final Logger LOGGER = Logger.getLogger(StAXParser.class);
    private boolean bId;
    private boolean bName;
    private boolean bEmail;
    private boolean bPassword ;
    private boolean bAddress_id;
    private static final String PATH_TO_XML_INPUT = "src/main/resources/xmlInput.xml";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ADDRESS = "Address";

    public void parser() {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(PATH_TO_XML_INPUT));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        switch (qName) {
                            case ID:
                                bId = true;
                                break;
                            case NAME:
                                bName = true;
                                break;
                            case EMAIL:
                                bEmail = true;
                                break;
                            case PASSWORD:
                                bPassword = true;
                                break;
                            case ADDRESS:
                                bAddress_id = true;
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:

                        Characters characters = event.asCharacters();
                        if(bId) {
                            LOGGER.info("Id: " + characters.getData());
                            bId = false;
                        }
                        if (bName) {
                            LOGGER.info("Name: " + characters.getData());
                            bName = false;
                        }
                        if (bEmail) {
                            LOGGER.info("email: " + characters.getData());
                            bEmail = false;
                        }
                        if (bPassword) {
                            LOGGER.info("password: " + characters.getData());
                            bPassword = false;
                        }
                        if (bAddress_id) {
                            LOGGER.info("Address id: " + characters.getData());
                            bAddress_id = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("Customers")) {
                            LOGGER.info("End Element : Customer");
                        }
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}