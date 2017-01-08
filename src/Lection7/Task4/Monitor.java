package Lection7.Task4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Monitor {

    private String path;
    private int timeout;
    private ArrayList<String> prev = new ArrayList<>();
    private ArrayList<String> curr = new ArrayList<>();
    private List<String> dateList = new ArrayList<>();
    private IFileEvents events;

    public Monitor(String path) {
        this.path = path;

        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            folder.mkdirs();
        }

        createArray(prev);
    }

    public void start() {
        while (true) {
            createArray(curr);
            compareArrays(prev, curr);
            prev.clear();
            prev.addAll(curr);

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int value) {
        timeout = value;
    }

    public IFileEvents getEvents() {
        return events;
    }

    public void setEvents(IFileEvents value) {
        events = value;
    }

    private void doFileAdded(String path) {
        if (events != null) {
            events.onFileAdded(path);
        }
    }

    private void doFileDeleted(String path) {
        if (events != null) {
            events.onFileDeleted(path);
        }
    }

    private void compareArrays(ArrayList<String> m1, ArrayList<String> m2) {
        Iterator<String> it = m1.iterator();
        String path;

        while (it.hasNext()) {
            path = it.next();

            if (!m2.contains(path)) {
                doFileDeleted(path);
            }
        }

        it = m2.iterator();
        while (it.hasNext()) {
            path = it.next();

            if (!m1.contains(path)) {
                doFileAdded(path);
            }
        }
    }

    private void createArray(ArrayList<String> output) {
        try {
            File file = new File(path);
            File[] list = file.listFiles();

            String info;
            output.clear();
            for (File f : list) {
                info = f.getCanonicalPath() + ", date: " + new Date(f.lastModified());
                output.add(info);
                dateList.add(info);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List getDateList() {
        return dateList;
    }
}
