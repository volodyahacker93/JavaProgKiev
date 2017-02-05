package Lection_9_2.Task_2;

public class Main {

    public static void main(String[] args) {
        String http = "http://website.com";
        Stress dos = new Stress(http, 100, true);
        dos.go();
    }
}
