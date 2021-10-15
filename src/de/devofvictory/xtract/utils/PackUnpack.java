package de.devofvictory.xtract.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;

public class PackUnpack {

    public static String packFile(File input) {

        String output = "";


        return output;
    }


    public static File unpackFile(String input, String path) throws IOException {

        File output = new File(path);
        if (!output.exists()) {

            output.mkdirs();
            output.createNewFile();

        }else {
            throw new FileSystemAlreadyExistsException();
        }


        return output;
    }
}
