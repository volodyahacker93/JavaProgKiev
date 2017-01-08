package Lection5_6.Task4;

public class Main {

    public static void main(String[] args) {
        try {
            Thread pt = new ParentThread();
            pt.start();

            Thread.sleep(5000);
            pt.interrupt();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
