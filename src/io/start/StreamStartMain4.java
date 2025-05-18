package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("temp/hello2.dat");
        byte[] inputs = new byte[]{65, 66, 67};
        fos.write(inputs);
        fos.close();
        FileInputStream fis = new FileInputStream("temp/hello2.dat");
        byte[] bytes = fis.readAllBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
