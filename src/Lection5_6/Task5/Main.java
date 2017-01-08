package Lection5_6.Task5;

public class Main {

    public static void main(String[] args) {
        try {
            CopyFile copy = new CopyFile("c:\\dir1\\1.txt", "c:\\dir1\\2.txt", 5120); // 5120 б - размер 1 блока
            Thread th = new Thread(copy);
            th.start();
            th.join();
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println("Copying is completed!");
    }
}