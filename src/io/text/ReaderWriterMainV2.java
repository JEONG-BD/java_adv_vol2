package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writerString = "BCD";
        System.out.println("writerString = " + writerString);


        FileOutputStream fos = new FileOutputStream(TextContent.FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        osw.write(writerString);
        osw.close();

        FileInputStream fis = new FileInputStream(TextContent.FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();

        int ch;
        while ((ch = isr.read()) != -1){
            sb.append((char) ch);
        }
        isr.close();
        System.out.println("sb = " + sb);
    }
    

}
