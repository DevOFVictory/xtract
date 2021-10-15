package de.devofvictory.xtract.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitProgression {

    public static String compressBits(String bits) {

        final String regex = "(\\w)\\1*";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(bits);

        List<String> parts = new ArrayList<>();
        while (matcher.find()) {
            parts.add(matcher.group(0));
        }

        String output = parts.get(0).charAt(0)+"";
        for (String part : parts) {
            output += amountToChar(part.length());
        }

        return output;

    }

    public static String decompressBits(String compressed) {
        String output = "";
        boolean zeroes = compressed.charAt(0) == '0';
        System.out.println(zeroes);
        for (int i = 1; i<compressed.length(); i++) {
            for (int j = 0; j<charToAmount(compressed.charAt(i)); j++) {
                output += (zeroes ? "0" : "1");
            }
            zeroes = !zeroes;
        }

        return output;
    }

    public static char amountToChar(int amount) {
        return (char)amount;
    }

    public static int charToAmount(char character) {
        return (int)character;
    }
}
