package was.v2;

import was.v1.HttpServerV1;

import java.io.IOException;

public class ServerMainV2 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpServerV1 httpServerV1 = new HttpServerV1(PORT);
        httpServerV1.start();
    }
}
