package Lection5_6.Task4;

public class ChildThread extends Thread {
    private static int threads;
    private int threadId;

    public ChildThread() {
        threadId = threads++;
    }

    @Override
    public void run(){
        System.out.println("Thread № " + threadId + " , ID: " + getId());

        while (!isInterrupted()) {
            Thread.yield();
        }
    }
}
