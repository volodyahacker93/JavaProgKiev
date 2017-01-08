package Lection4.Task7;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class Files {

    public static void copy(String dirName) throws IOException {

        File dir = new File(dirName);
        if (!dir.exists()) {
            System.out.println("The specified directory is not available!");
            return;
        }

        File[] fileList = dir.listFiles();
        Vector vect = new Vector();

        for (File file : fileList) {
            vect.addElement(new FileInputStream(file));
        }

        try (SequenceInputStream sis = new SequenceInputStream(vect.elements());
             FileOutputStream fos = new FileOutputStream(dirName + "\\" + "OUT.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] buf = new byte[2048];
            int size;
            do {
                size = sis.read(buf, 0, buf.length);
                if (size > 0) {
                    bos.write(buf, 0, size);
                }
            } while (size > 0);
        }
    }
}