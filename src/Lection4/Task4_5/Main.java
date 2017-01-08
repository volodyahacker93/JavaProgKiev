package Lection4.Task4_5;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String outDir = "c:\\dir1";
        String inDir = "c:\\dir2";

        try {
            Files.copy(outDir,inDir);
            Files.aboutFiles(inDir);
        } catch (IOException ex) {
            ex.getMessage();
        }

        System.out.println("Done!");
    }
}
