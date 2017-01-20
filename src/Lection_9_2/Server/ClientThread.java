package Lection_9_2.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread{

    private Socket socket;
    private List<Message> msg;
    private int pos = 0;
    private String name;

    public ClientThread(Socket socket, List<Message> msg) {
        super();
        this.socket = socket;
        this.msg = msg;
    }

    private void listToBytes(OutputStream os) throws IOException{
        final int sz = msg.size();
        for (int i = pos; i <= sz; i++) {
            msg.get(i).writeToStream(os);
        }

        pos = msg.size();
    }

    @Override
    public void run() {
        try {
            final InputStream is = socket.getInputStream();
            final OutputStream os = socket.getOutputStream();

            while (!isInterrupted()) {
                if(pos < msg.size()) {
                    listToBytes(os);
                }

                Message m = Message.readFromSream(is);
                if(m != null) {
                    System.out.println(m.toString());
                    msg.add(m);
                    if(name == null) {
                        name = m.from;
                        setName(name);
                    }
                }
            }
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
