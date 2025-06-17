package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path dir = Path.of("temp/exampleDir2");

        System.out.println("Files.exists(file) = " + Files.exists(file));
        try {
            Files.createFile(file);
            System.out.println("file created");
        } catch (FileAlreadyExistsException e) {
            System.out.println("file already");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.createDirectories(dir);
        } catch (FileAlreadyExistsException e) {
            System.out.println("file already");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean regularFile = Files.isRegularFile(file);
        System.out.println("regularFile = " + regularFile);
        boolean isDir = Files.isDirectory(dir);
        System.out.println("isDir = " + isDir);
        //Files.delete(file);
        //Files.delete(dir);
    }
}
