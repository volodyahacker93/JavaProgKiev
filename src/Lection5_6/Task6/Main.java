package Lection5_6.Task6;

public class Main {

    public static void main(String[] args) {
        try {
            CopyFile copy = new CopyFile("c:\\dir1\\1.pdf", "c:\\dir1\\2.pdf", new Progress());
            Thread th = new Thread(copy);
            th.start();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}