package Lection5_6.Task8;

import java.io.IOException;
import java.io.RandomAccessFile;

public class InFile {
    private String path;

    public InFile(String path) {
        this.path = path;
    }

    public synchronized void write(String text) {
        try (RandomAccessFile out = new RandomAccessFile(path, "rw")) {
            out.seek(out.length());
            out.write(text.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
