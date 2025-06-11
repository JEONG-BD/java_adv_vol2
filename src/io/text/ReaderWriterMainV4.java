package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {

        String writerString = "ABC\n가나다";
        System.out.println("writerString = " + writerString);


        FileWriter fw = new FileWriter(TextContent.FILE_NAME, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writerString);
        bw.close();
        
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(TextContent.FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while ((line = br.readLine()) != null ){
            sb.append(line).append("\n");
        }
        System.out.println("sb = " + sb);
        br.close();
        fr.close();

        
        
    }
}
