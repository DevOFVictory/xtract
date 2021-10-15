package de.devofvictory.xtract;

import de.devofvictory.xtract.utils.BitProgression;
import de.devofvictory.xtract.utils.OtherUtils;

import java.io.File;
import java.io.IOException;

public class XTract {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\delfi\\Desktop\\XTract\\test.jpg");

        String binaryInput = OtherUtils.fileToBinary(file);
        String compressed = BitProgression.compressBits(binaryInput);

        String decompressed = BitProgression.decompressBits(compressed);

        System.out.println(compressed);
        System.out.println(decompressed);



        System.out.println("Compression Rate: " + OtherUtils.getCompressionRate(binaryInput, compressed) + "%");
    }
}
