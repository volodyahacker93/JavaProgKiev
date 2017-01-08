package Lection4.Task7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String dir = "c:\\dir1";
        try {
            Files.copy(dir);
        } catch (IOException ex) {
            ex.getMessage();
        }
        System.out.println("Done!");
    }
}