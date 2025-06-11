package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString = " + writeString);
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("writeBytes = " + Arrays.toString(writeBytes));

        FileOutputStream fos = new FileOutputStream(TextContent.FILE_NAME);
        fos.write(writeBytes);
        fos.close();


        FileInputStream fis = new FileInputStream(TextContent.FILE_NAME);
        byte[] bytes = fis.readAllBytes();
        fis.close();

        String readString = new String(bytes, UTF_8);
        System.out.println("readString = " + readString);
    }
}
