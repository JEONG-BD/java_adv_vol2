package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Session implements Runnable{

    private final Socket socket;

    private final DataInputStream input;
    private final DataOutputStream output;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private boolean closed = false;

    private String userName;

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.sessionManager.add(this);
    }

    public void close(){
        if(closed) return;

        closeAll(socket, input, output);
        closed = true;
        log("연결 종료 : " + socket);

    }


    @Override
    public void run() {
        try {
            while (true){
                String received = input.readUTF();
                log("client -> server : " + received );

                // 메시지 전체 보내기
                //sessionManager.sendAll(received);
                commandManager.execute(received, this);

            }

        }catch (IOException e){
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(userName + "님이 퇴장하였습니다");
            close();
        }
    }

    public void send(String message) throws IOException {
        log("server -> client : " + message);
        output.writeUTF(message);
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
