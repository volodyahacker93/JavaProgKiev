package Lection5_6.Task4;

import java.util.ArrayList;

public class ParentThread extends Thread {

    @Override
    public void run() {
        ArrayList<Thread> threads = new ArrayList<>();
        Thread ct;
        for (int i = 0; i <= 50; i++) {
            ct = new ChildThread();
            ct.start();
            threads.add(ct);
        }

        while (!isInterrupted()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                threads.stream().forEach((thread -> thread.interrupt()));

                System.out.println("All threads is interrupted.");
                return;
            }
        }
    }
}

