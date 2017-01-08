package Lection4.Task2;

import java.io.File;

public class Main {

    static void find(String dirName) {
        File dir = new File(dirName);
        File[] fileList = dir.listFiles();
        for (File f : fileList) {
            if (f.getName().length() > 5 && f.getName().charAt(1) == 'A') {
                System.out.println((f.isFile() ? "File: " : "Directory: ") + f.getPath());
            }
            if (f.isDirectory()) {
                find(f.getPath());
            }
        }
    }

    public static void main(String[] args) {
        String dir = "c:\\dir1";
        find(dir);
    }
}