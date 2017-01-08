package Lection4.Task6;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String srcPath = "c:\\dir1\\file.txt";
        String oldWord = "Hello";
        String newWord = "1234";

        try {
            String text = Files.read(srcPath);
            text = text.replace(oldWord,newWord);
            Files.write(srcPath,text);
        } catch (IOException ex) {
            ex.getMessage();
        }

        System.out.println("Done!");
    }
}
