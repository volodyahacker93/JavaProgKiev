package Lection4.Task6;

import java.io.*;

public class Files {

    public static String read(String file) throws IOException {
        try(FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] buf = new byte[bis.available()];
            bis.read(buf);
            String text = new String (buf);
            return text;
        }
    }

    public static void write(String file, String text) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] buf = text.getBytes();
            bos.write(buf, 0, buf.length);
        }
    }
}
