package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.*;

public class ReadTextFileV1 {

    private static final String PATH  = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writerStr = "abc\n가나다";
        System.out.println("writerStr = " + writerStr);

        Path path = Path.of(PATH);

        Files.writeString(path, writerStr, UTF_8);
        String readStr = Files.readString(path, UTF_8);
    }
}
