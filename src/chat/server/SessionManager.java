package chat.server;

import network.tcp.v6.SessionV6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;

public class SessionManager {
    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session){
        sessions.add(session);
    }

    public synchronized void remove(Session session){
        sessions.remove(session);
    }

    public synchronized void closeAll(){
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public synchronized  void sendAll(String received) {
        for (Session session : sessions) {
            try {
                session.send(received);
            } catch (IOException e){
                log(e);
            }
        }
    }

    public synchronized List<String> getAllUserName(){
        List<String> userNames = new ArrayList<>();
        for (Session session : sessions) {
            if(session.getUserName() != null){
                userNames.add(session.getUserName());
            }
        }
        return userNames;
    }
}
