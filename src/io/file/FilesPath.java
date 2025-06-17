package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesPath {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);
        System.out.println("Absolute Path = " + path.toAbsolutePath());
        System.out.println("Canonical Path = " + path.toAbsolutePath());

        List<Path> collect = Files.list(path).collect(Collectors.toList());

        collect.stream().forEach(file -> System.out.println(file.getFileName()));


    }
}
