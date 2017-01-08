package Lection5_6.Task5;

import java.io.*;

class CopyFile implements Runnable {
    private final File inFile;
    private final File outFile;
    private int blockSize;

    public CopyFile(String inFile, String outFile, int blockSize) {
        this.inFile = new File(inFile);
        this.outFile = new File(outFile);
        this.blockSize = blockSize;
    }

    @Override
    public void run() {
        if (!inFile.exists() || !inFile.isFile()) {
            System.out.println("The specified file is not available!");
            return;
        }
        try (InputStream in = new FileInputStream(inFile);
             OutputStream out = new FileOutputStream(outFile);) {
            Block block = new Block(in, out, blockSize);
            Thread th;
            long size = 0;
            while (size < inFile.length()) {
                th = new Thread(block);
                th.start();
                size += blockSize;
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public File getInputFile() {
        return inFile;
    }

    public File getOutputFile() {
        return outFile;
    }
}