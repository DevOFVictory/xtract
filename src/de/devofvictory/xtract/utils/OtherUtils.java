package de.devofvictory.xtract.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OtherUtils {

    public static double getCompressionRate(String before, String after) {
        double beforeLength = convertStringToBinary(before).length();
        double afterLength = convertStringToBinary(after).length();


        return 100-afterLength/beforeLength*100;
    }


    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }

    public static String getBits(byte b)
    {
        String result = "";
        for(int i = 0; i < 8; i++)
            result += (b & (1 << i)) == 0 ? "0" : "1";
        return result;
    }

    public static String fileToBinary(File file) throws IOException {
        byte[] fileData = new byte[(int) file.length()];
        FileInputStream in = new FileInputStream(file);
        in.read(fileData);
        in.close();

        String output = "";
        for (byte b : fileData) {
            output += getBits(b);
        }
        return output;
    }

}
