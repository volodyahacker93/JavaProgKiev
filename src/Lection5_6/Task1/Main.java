package Lection5_6.Task1;

public class Main {

    public static class Counter extends Thread {
        public void run() {
            int x = 1;
            while (!isInterrupted()) { // условие завершения потока №1
                for (int i = 1; i < 25; i++) {
                    System.out.print(i + " ");
                }

                System.out.println();

                try {
                    Thread.sleep(1000); // закомментировать
// Thread.yield(); // или так
                } catch (InterruptedException e) {
                    return; // условие завершения потока №2
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Counter c = new Counter();
            c.start(); // запускаем поток
            Thread.sleep(5000); // ждем 5 сек
            c.interrupt(); // прерываем поток
        } catch (Exception e) {
            ;
        }
    }
}