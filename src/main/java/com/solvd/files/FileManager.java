package com.solvd.files;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import com.solvd.files.enums.Constrains;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class);

    public static String filterLineBreak(String input) {
        return input.replaceAll("\\r|\\n", "");
    }

    public static String filterConstrains(String input) {
        return filterLineBreak(input).toLowerCase().replaceAll(Constrains.generateRegEx(), "");
    }

    public static String[] fileContentToArray(File file, String encoding) throws IOException {
        return filterConstrains(FileUtils.readFileToString(file, encoding)).split(" ");
    }

    public static Map<String, Integer> countDuplicateWords(String[] words) {
        Map<String, Integer> duplicateWords = new HashMap<>();

        for(String word : words) {
            if (duplicateWords.containsKey(word))
                duplicateWords.put(word, duplicateWords.get(word) + 1);
                duplicateWords.put(word, 1);
        }

        return duplicateWords;
    }

    public static String outputString(String key, Integer value) {
        return String.format("%s: %x;\n",key, value);
    }

    public static void writeStringToFile(Map<String, Integer> data, File output) {
        data.forEach((k, v) -> {
            try {
                FileUtils.writeStringToFile(output, outputString(k, v), "utf-8", true);
            } catch (IOException e) {
              LOGGER.error(e.getMessage());
            }
        });
    }
}
