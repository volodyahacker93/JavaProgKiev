package Lection5_6.Task3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            ArrayList<Thread> threads = new ArrayList<>();
            Thread mt;
            for (int i = 0; i <= 100; i++) {
                mt = new MyThread();
                mt.start();
                threads.add(mt);
            }
            Thread.sleep(5000);

            threads.stream().forEach((thread -> thread.interrupt()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
