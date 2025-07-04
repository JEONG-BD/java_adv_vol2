package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable {

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;
    private boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String userName = inputUserName(scanner);
            output.writeUTF("/join" + DELIMITER + userName);

            while (true) {
                String toSend = scanner.nextLine();

                if (toSend.isEmpty()) {
                    continue;
                }

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/" 시작하면 명령어 나머지는 메시지

                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUserName(Scanner scanner) {
        System.out.println("이름 입력!");
        String userName;

        do {
            userName = scanner.nextLine();
        } while (userName.isEmpty());
        return userName;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        try {
            System.in.close();

        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("writeHandler 종료");
    }
}