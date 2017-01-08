package Lection5_6.Task2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static class Time extends Thread {
        public void run() {
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
            long systemTime;

            while (!isInterrupted()) {
                systemTime = System.currentTimeMillis();
                System.out.println(timeFormat.format(systemTime));
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter \"STOP\" to stop.");

            Time t = new Time();
            t.start();

            while (!t.isInterrupted()) {
                if (scan.next().equalsIgnoreCase("stop")) {
                    t.interrupt();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
