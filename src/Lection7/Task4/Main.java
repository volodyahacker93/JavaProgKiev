package Lection7.Task4;

public class Main {

    private static class MyEvents implements IFileEvents {

        @Override
        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
        }

        @Override
        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }
    }

    public static void main(String[] args) {

        Monitor m = new Monitor("c:\\dir1");
        m.setTimeout(2000);
        m.setEvents(new MyEvents());
        m.start();
    }
}
