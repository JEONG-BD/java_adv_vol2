package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private static final String PATH  = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writerStr = "abc\n가나다";
        System.out.println("writerStr = " + writerStr);

        Path path = Path.of(PATH);

        Files.writeString(path, writerStr, UTF_8);
        List<String> strings = Files.readAllLines(path, UTF_8);
        strings.stream().forEach(System.out::println);

        try(Stream<String> lines = Files.lines(path, UTF_8)){
            lines.forEach(System.out::println);
        }

    }
}
