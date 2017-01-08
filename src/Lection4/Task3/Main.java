package Lection4.Task3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String srcPath = "c:\\dir1\\file.txt";
        String oldWord = "Hello";
        String newWord = "1234";
        try {
/*String text = Files.read(srcPath);
text = text.replace(oldWord, newWord);
Files.write(srcPath, text);*/
            Files.replase(srcPath, oldWord, newWord);
        } catch (IOException ex) {
            ex.getMessage();
        }
        System.out.println("Done!");
    }
}