package network.tcp.v4;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

public class ClientV4 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            socket = new Socket("localhost", PORT);
            System.out.println("socket.getInetAddress() = " + socket.getInetAddress());
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            log("소켓 연결 " + socket);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("전송문자");
                String toSend = scanner.nextLine();

                output.writeUTF(toSend);
                log("client -> server " + toSend);
                if (toSend.equals("exit")){
                    break;
                }

                String received = input.readUTF();
                log("client <- server " + received);
            }

        } catch (IOException e){
            log(e);
        } finally {
            closeAll(socket, input, output);
        }

        log("연결 종료 " + socket);

    }
}
