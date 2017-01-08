package Lection5_6.Task5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Block implements Runnable {
    private InputStream inStream;
    private OutputStream outStream;
    private int blockSize;

    public Block(InputStream in, OutputStream out, int size) {
        inStream = in;
        outStream = out;
        blockSize = size;
    }

    @Override
    public void run() {
        copy();
    }

    private synchronized void copy() {
        byte[] buffer = new byte[(int) (blockSize / 100)];
        int size;
        try {
            while ((size = inStream.read(buffer)) > 0 && size < blockSize) {
                outStream.write(buffer, 0, size);
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}