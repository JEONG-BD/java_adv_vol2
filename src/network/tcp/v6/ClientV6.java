package network.tcp.v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        try (Socket socket = new Socket("localhost", PORT);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {
            System.out.println("socket.getInetAddress() = " + socket.getInetAddress());
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

        } catch (IOException e) {
            log(e);
        }
    }
}
