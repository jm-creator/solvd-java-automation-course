package com.solvd.connectionPool.utils;

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

    boolean bName = false;
    boolean bEmail = false;
    boolean bPassword = false;
    boolean bAddress_id = false;
    private static final String PATH_TO_XML_INPUT = "src/main/resources/xmlInput.xml";

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

                        if (qName.equalsIgnoreCase("Customer")) {
                            System.out.println("Start Element : Customer");
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String id = attributes.next().getValue();
                            System.out.println("id : " + id);
                        } else if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase("email")) {
                            bEmail = true;
                        } else if (qName.equalsIgnoreCase("password")) {
                            bPassword = true;
                        } else if (qName.equalsIgnoreCase("addres_id")) {
                            bAddress_id = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bName) {
                            System.out.println("Name: " + characters.getData());
                            bName = false;
                        }
                        if (bEmail) {
                            System.out.println("email: " + characters.getData());
                            bEmail = false;
                        }
                        if (bPassword) {
                            System.out.println("password: " + characters.getData());
                            bPassword = false;
                        }
                        if (bAddress_id) {
                            System.out.println("Address id: " + characters.getData());
                            bAddress_id = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("Customer")) {
                            System.out.println("End Element : Customer");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}