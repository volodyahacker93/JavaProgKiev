package Lection4.Task3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Files {

    public static String read(String file) throws IOException {
        try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
            byte[] buf = new byte[(int) in.length()];
            in.read(buf);
            String text = new String(buf);
            return text;
        }
    }

    public static void write(String file, String text) throws IOException {
        try (RandomAccessFile out = new RandomAccessFile(file, "rw")) {
            byte[] buf = text.getBytes();
            out.setLength(0);
            out.write(buf);
        }
    }

    public static void replase(String file, String oldWord, String newWord) throws IOException {
        try (RandomAccessFile in = new RandomAccessFile(file, "r");
             RandomAccessFile out = new RandomAccessFile(file, "rw")) {

            byte[] buf = new byte[(int) in.length()];
            in.read(buf);
            String text = new String(buf);
            text = text.replace(oldWord, newWord);

            buf = text.getBytes();
            out.setLength(0);
            out.write(buf);
        }
    }

    public static void replase2(String file, String oldWord, String newWord) throws IOException {
        try (RandomAccessFile stream = new RandomAccessFile(file, "rw")) {

            byte[] buf = new byte[(int) stream.length()];
            stream.read(buf);
            String text = new String(buf);
            text = text.replace(oldWord, newWord);

            buf = text.getBytes();
            stream.setLength(0);
            stream.write(buf);
        }
    }
}