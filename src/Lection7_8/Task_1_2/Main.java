package Lection7_8.Task_1_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        translator.addWords();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text for translation:");
        String text = scanner.next();
        System.out.println(translator.translate(text));
    }
}