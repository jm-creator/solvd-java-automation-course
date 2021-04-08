package com.solvd.reflection;


import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> myObj = Class.forName("java.util.ArrayList");

        LOGGER.info("Get constructors");
        Arrays.stream(myObj.getConstructors()).forEach(LOGGER::info);

        LOGGER.info("Get methods");
        Arrays.stream(myObj.getMethods()).forEach(LOGGER::info);

        LOGGER.info("get implemented interfaces");
        Arrays.stream(myObj.getInterfaces()).forEach(LOGGER::info);

        Constructor<?> constructor = null;
        try {
            constructor = myObj.getConstructor();
        } catch (NoSuchMethodException e) {
            LOGGER.info(e.getMessage());
        }
        Object list = null;
        try {
            if (constructor != null) list = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("ArrayList class: " + list.getClass());
    }

}