package Lection5_6.Task7;

import Lection5_6.Task7.Finish;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        try {
            int arg = 10; // Входящее число
            int number = 3; // Количество потоков
            int start = arg;
            int end;

            Finish finish = new Finish();
            Task task;
            Thread thread;

            long startTime;
            long endTime;
            startTime = System.nanoTime();
            for (int i = 0; i < number; i++) {
                end = start - arg / number;
                if (end <= 0) {
                    end = 1;
                }
                task = new Task(BigInteger.valueOf(start), BigInteger.valueOf(end), finish);
                thread = new Thread(task);
                thread.start();

                start = end - 1;
            }
            endTime = System.nanoTime();
            Thread.sleep(1000);

            BigInteger result = finish.getResult();
            System.out.println(arg + "! = " + result);
            System.out.println("Time = " + ((endTime - startTime)/1000) + " ms");
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
}
