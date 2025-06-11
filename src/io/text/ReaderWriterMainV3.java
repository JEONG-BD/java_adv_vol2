package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {

        String writerString = "EEE";
        System.out.println("writerString = " + writerString);


        FileWriter fw = new FileWriter(TextContent.FILE_NAME, StandardCharsets.UTF_8);
        fw.write(writerString);
        fw.close();
        
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(TextContent.FILE_NAME, StandardCharsets.UTF_8);
        int ch; 
        while ((ch = fr.read()) != -1){
            sb.append((char)ch);
        }
        System.out.println("sb = " + sb);
        fr.close();
        
        
    }
}
