package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");
        System.out.println("File exists " + file.exists());

        file.createNewFile();

        boolean disCreated = directory.mkdir();
        System.out.println("Directory " + disCreated);

        System.out.println("Directory created " + disCreated);

        //boolean fileDeleted = file.delete();
        //System.out.println(fileDeleted);
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("directory.isDirectory() = " + directory.isDirectory());
        System.out.println("file.getName() = " + file.getName());
        File newFile = new File("temp/newExample.txt");
        boolean renamedFile = file.renameTo(newFile);
        System.out.println("renamedFile = " + renamedFile);
        long lastModified = newFile.lastModified();
        System.out.println("lastModified = " + new Date(lastModified));
    }
}
