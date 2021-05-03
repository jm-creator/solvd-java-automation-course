package com.solvd.connectionPool.utils;

import com.solvd.connectionPool.models.BaseModel;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JaxBParser {
    private static final Logger LOGGER = Logger.getLogger(JaxBParser.class);
    private static final String PATH_TO_INPUT = "src/main/resources/xmlInput.xml";
    private static final String PATH_TO_OUTPUT = "src/main/resources/xmlOutput.xml";

    public static void serialize(JaxBList<? extends BaseModel> models, Class<? extends BaseModel> classType) {
        try {
            Marshaller marshaller = JAXBContext.newInstance(classType).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(models, new File(PATH_TO_OUTPUT));
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static <T>Object deSerialize(Class<T> classType) {
        try {
            Unmarshaller unmarshaller = JAXBContext
                    .newInstance(classType)
                    .createUnmarshaller();

            return classType.cast(unmarshaller.unmarshal(new FileInputStream(PATH_TO_INPUT)));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
