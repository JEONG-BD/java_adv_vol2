package network.tcp.v5;

import network.tcp.v4.SessionV4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class Server5 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트 " + PORT);


        while (true){
            Socket socket = serverSocket.accept();
            log("소켓 연결 : " + socket);
            SessionV5 sessionV4 = new SessionV5(socket);
            Thread thread = new Thread(sessionV4);
            thread.start();
        }
    }
}
