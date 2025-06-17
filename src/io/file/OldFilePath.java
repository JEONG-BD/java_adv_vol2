package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OldFilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path = " + file.getPath());
        System.out.println("Absolute Path = " + file.getAbsolutePath());
        System.out.println("Canonical Path = " + file.getCanonicalPath());

        File[] files = file.listFiles();


        Arrays.stream(files)
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName()));

        //Arrays.stream(files)
        //        .map(file1 -> file1.isFile()? "F" : "D")
        //        .forEach();
        Arrays.stream(files)
                .forEach(f -> System.out.println(f.getName() + " : " + (f.isFile() ? "F" : "D")));

    }

}
