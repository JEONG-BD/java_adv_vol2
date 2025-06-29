package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();
        try {
            // 타임아웃 시간 설정
            socket.setSoTimeout(3000);
            int read = input.read();
            // 연결 가정 아무 것도 출력 되지 않음
            System.out.println("read = " + read);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
