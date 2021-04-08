package com.solvd.files;
import org.apache.log4j.Logger;
import com.solvd.files.enums.FilePath;
import java.io.File;
import java.io.IOException;
import static com.solvd.files.FileManager.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(FileManager.class);
    public static void main(String[] args) {
        File file = new File(FilePath.INPUT.contentRootPath);
        LOGGER.info("creating file output.txt with duplicate words");
        try {
            writeStringToFile(countDuplicateWords(
                    fileContentToArray(file, "utf-8")),
                    new File(FilePath.OUTPUT.contentRootPath));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

