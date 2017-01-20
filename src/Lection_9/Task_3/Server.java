package Lection_9.Task_3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
*Написать сервер, который будет отправлять пользователю информацию о системе и номер запроса.
*/
public class Server {

    private static Integer numberRequest;
    private int port;
    private Thread thread;

    public Server(int port) {
        numberRequest = 0;
        this.port = port;
    }

    public void stop() {
        thread.interrupt();
    }

    public void start() throws IOException {
        thread = new Thread() {
            @Override
            public void run() {
                try (ServerSocket server = new ServerSocket(port);){
                    while (!isInterrupted()) {
                        try (Socket socket = server.accept();
                                 OutputStream output = socket.getOutputStream()) {
                            String info = getInfo();
                            output.write(info.getBytes());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("OS: ").append(System.getenv("OS"))
                .append("\n\nProcessor: ")
                .append("\n identifier - ")
                .append(System.getenv("PROCESSOR_IDENTIFIER"))
                .append("\n architecture - ")
                .append(System.getenv("PROCESSOR_ARCHITECTURE"))
                .append("\n cores - ")
                .append(Runtime.getRuntime().availableProcessors())
                .append("\n\nRequest number: ")
                .append(++numberRequest);

        return sb.toString();
    }
}
