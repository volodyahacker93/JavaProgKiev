package Lection5_6.Task3;

public class MyThread extends Thread{

    private static int counter;
    private int id;

    public MyThread() {
        id = counter++;
    }

    @Override
    public void run(){
        System.out.println("Thread № " + id);
        while (!isInterrupted()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

