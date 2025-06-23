package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements  CommandManager {

    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if(totalMessage.startsWith("/join")){
            String[] split = totalMessage.split(DELIMITER);
            String userName = split[1];
            session.setUserName(userName);
            sessionManager.sendAll(userName + "님이 입장했습니다");
        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUserName() + "] : " + message);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String changeName = split[1];
            sessionManager.sendAll(session.getUserName() + " 님이 " + changeName + " 로 이름을 변경했습니다.");
            session.setUserName(changeName);

        } else if (totalMessage.startsWith("/users")) {
            List<String> userNames = sessionManager.getAllUserName();
            StringBuilder sb = new StringBuilder();

            sb.append("전체 접속자" ).append(userNames.size()).append("\n");
            for (String userName : userNames) {
                sb.append(" - " ).append(userName).append("\n");
            }
            session.send(sb.toString()) ;
        } else if(totalMessage.startsWith("/exit")){
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다 : " + totalMessage);
        }


        //sessionManager.sendAll(totalMessage);

    }
}
