package Lection5_6.Task6;

import java.io.*;

public class CopyFile implements Runnable {
    private final File inFile;
    private final File outFile;
    private final IProgress progress;
    private int blockSize;

    public CopyFile(String inFile, String outFile, IProgress progress) {
        this.inFile = new File(inFile);
        this.outFile = new File(outFile);
        this.progress = progress;
        blockSize = 1048676; // 1 MB
    }

    @Override
    public void run() {
        if (!inFile.exists() || !inFile.isFile()) {
            System.out.println("The specified file is not available!");
            return;
        }
        try (FileInputStream fis = new FileInputStream(inFile);
             FileOutputStream fos = new FileOutputStream(outFile);) {
            byte[] buffer = new byte[blockSize];
            int size;
            while ((size = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, size);
                if (progress != null) {
                    progress.update((double) size * 100 / inFile.length());
                }
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

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int size) {
        blockSize = size;
    }

    public int getProgress() {
        return progress.getProgress();
    }
}