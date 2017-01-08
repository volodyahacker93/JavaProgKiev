package Lection3.Task8;

import java.io.File;
import java.util.Date;

public class Monitor {
    String file;
    IFileEvent event;

    public Monitor(String file, IFileEvent event) {
        this.file = file;
        this.event = event;
    }

    public void start() {
        while (true) {
            File f = new File(file);

            if (f.exists() && f.isFile()) {
                if (event != null) {
                    event.onFileAdded(file);
                    System.out.println("Last Modif " + f.lastModified());
                    System.out.println("Date: " + new Date(f.lastModified()));
                }
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println("Waiting...");
        }
    }
}
