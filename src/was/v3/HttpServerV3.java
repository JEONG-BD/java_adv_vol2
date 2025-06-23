package was.v3;

import was.v2.HttpRequestHandlerV2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class HttpServerV3 {

    private final int port;

    private final ExecutorService es = Executors.newFixedThreadPool(10);

    public HttpServerV3(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("server start");

        while (true){
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandlerV3(socket));
        }
    }
}
