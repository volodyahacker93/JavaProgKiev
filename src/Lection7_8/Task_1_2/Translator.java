package Lection7_8.Task_1_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Translator {
    private String nameBase;
    private HashMap<String, String> base;

    public Translator() {
        this.nameBase = "base.txt";
        base = new HashMap<>();
    }

    public Translator(String fileName, HashMap<String, String> base) {
        this.nameBase = fileName;
        this.base = base;
    }

    public void loadBase() {
        loadBase(nameBase);
    }

    public void loadBase(String fileBase) {
        File file = new File(fileBase);
        if (file.exists() && file.isFile() && file.length() > 0) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                base = (HashMap<String, String>) input.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Base is absent!");
            base = new HashMap<>();
        }
    }

    public void addWords() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            addWord();
            System.out.println("Continue? Yes/No");
            String temp = scanner.nextLine();
            if (!temp.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word and translation through the \"-\"!");
        String[] words = scanner.nextLine().trim().split("-");
        if (words.length == 2) {
            base.put(words[0].replace(" ", ""), words[1].replace(" ", ""));
            save();
        } else {
            System.out.println("Invalid entry!");
        }
    }

    public String translate(String text) {
        if (base != null) {
            return transl(text);
        } else {
            System.out.println("Base is absent!");
            return null;
        }
    }

    private String transl(String text) {
        String[] words = text.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (base.containsKey(word)) {
                sb.append(base.get(word)).append(" ");
            } else {
                sb.append("\"").append(word).append("\" - an unknown word.");
            }
        }
        return sb.toString();
    }

    public void save() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nameBase))) {
            output.writeObject(base);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setNameBase(String nameBase) {
        this.nameBase = nameBase;
    }

    public String getNameBase() {
        return nameBase;
    }

    public void setBase(HashMap<String, String> base) {
        this.base = base;
    }

    public HashMap<String, String> getBase() {
        return base;
    }
}