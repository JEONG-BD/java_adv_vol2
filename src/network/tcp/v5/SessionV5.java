package network.tcp.v5;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class SessionV5 implements Runnable{

    private final Socket socket;


    public SessionV5(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {

        try(socket;
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());){

            while (true){
                String received = input.readUTF();
                log("client -> server " + received);

                if(received.equals("exit")){
                    break;
                }
                String toSend =  received + " World !";
                output.writeUTF(toSend);
                log(" client <- server " + toSend);

                log("연결 종료 " + socket);
            }

            input.close();
            output.close();
            socket.close();


        } catch (IOException e) {
            log(e);
        }

        log("연결 종료 : " + socket + " is Closed " + socket.isClosed());
    }
}
