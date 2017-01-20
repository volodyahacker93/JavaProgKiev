package Lection_9_2.Task_1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ServerPing sp = new ServerPing("c://dir1/server.txt", "c://dir1/report.txt");
            sp.getStatucConnectionReport();
        } catch (FileNotFoundException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
