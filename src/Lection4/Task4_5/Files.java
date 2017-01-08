package Lection4.Task4_5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Files {

    public static void copy(String outDirPath, String inDirPath) throws IOException {

        File outDir = new File(outDirPath);
        File inDir = new File(inDirPath);

        if (!outDir.exists() || !outDir.isDirectory()) {
            throw new IOException("The specified directory is not available!");
        }

        if (!inDir.exists()) {
            inDir.mkdirs();
        }

        File[] fileList = outDir.listFiles();

        for (File file : fileList) {
            if (file.isFile()) {
                System.out.print("Copying file \"" + file.getName() + "\" (" + file.length() + " bytes)");
                copyFile(file.getPath(), inDirPath + "\\" + file.getName());
                System.out.println(" - done!");
            }
            if (file.isDirectory()) {
                copy(file.getPath(), inDirPath + "\\" + file.getName());
            }
        }
    }

    public static void copyFile(String file1, String file2) throws IOException {
        try (InputStream in = new FileInputStream(file1);
             OutputStream out = new FileOutputStream(file2)) {

            byte[] buffer = new byte[1024 * 1024 * 30];
            int size;
            while ((size = in.read(buffer)) > 0) {
                out.write(buffer, 0, size);
            }
        }
    }

    //********************************************************************************
    public static void aboutFiles(String dirPath) throws IOException {
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("The specified directory is not available!");
            return;
        }

        File[] fileList = dir.listFiles();
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        String text;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dirPath + "\\" + "info.txt"))) {
            for (File file : fileList) {
                if (file.isFile()) {
                    date = new Date(file.lastModified());
                    text = file.getName() + ", date: " + dateFormat.format(date) + "\r\n";
                    bw.write(text);
                }
            }
        }
    }
}
