package was.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;
import static util.MyLogger.log;

public class HttpServerV1 {

    private final int port;

    public HttpServerV1(int port) {
        this.port = port;
    }

    public void start() throws IOException, InterruptedException {
        ServerSocket severSocket = new ServerSocket(port);
        log("Server 시작");

        while (true){
            Socket socket = severSocket.accept();
            process(socket);
        }
    }

    private void process(Socket socket) throws IOException, InterruptedException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)){

            String requestStr =  requestToString(reader);

            if(requestStr.contains("/favicon.ico")){
                log("Favicon 요청");

            }
            log("HTTP 요청 정보 출력");
            System.out.println(requestStr);
            log("HTTP 응답 생성");
            sleep();
            responseToClient(writer);
            log("HTTP 응답 전송 완료");

        }
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    private void responseToClient(PrintWriter writer) {
        String body = "<h1>Hello world</h1>";
        int length = body.getBytes(UTF_8).length;
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\r\n");
        sb.append("Content-Type: text/html\r\n");
        sb.append("Content-Length: ").append(length).append("\r\n");
        sb.append("\r\n");
        sb.append(body);
        writer.println(sb);
        writer.flush();

    }

    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null){
            if(line.isEmpty()){
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

}
