package Lection3.Task9_10;

import java.io.File;
import java.util.Arrays;

public class Monitor {

    private String[] name;
    private IFileEvent event;

    public Monitor(String name, IFileEvent event) {
        this.name = new String[1];
        this.name[0] = name;
        this.event = event;
    }

    public Monitor(String[] name, IFileEvent event) {
        this.name = Arrays.copyOf(name, name.length);
        this.event = event;
    }

    public void start() {
        File[] file = new File[name.length];

        while (true) {
            int counter = 0;
            for (int i = 0; i < file.length; i++){
                if (name[i] != null){
                    file[i] = new File(name[i]);
                    if (file[i].exists() && file[i].isFile()){
                        if (event != null) {
                            event.onFileAdded(file[i]);
                        }
                        name[i] = null;
                        counter++;
                    }
                }
            }

            if (counter == file.length) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Waiting...");
        }
    }

    public void monitoring (String nameDir, String type, int time) {
        System.out.println("Monitoring of \"" + nameDir + "\" directory:");
        File dir = new File(nameDir);
        File[] oldList = dir.listFiles();
        File[] newList;

        while (true) {
            newList = dir.listFiles();

            if(!Arrays.equals(oldList, newList)){
                String operation;
                File[] list1;
                File[] list2;

                if (newList.length > oldList.length){
                    operation = "New file: ";
                    list1 = newList;
                    list2 = oldList;
                } else if (oldList.length > newList.length) {
                    operation = "Delete file: ";
                    list1 = oldList;
                    list2 = newList;
                } else {
                    operation = "Rename file: ";
                    list1 = newList;
                    list2 = oldList;
                }

                boolean check;

                for (File f2 : list1) {
                    check = true;
                    for (File f1 : list2) {
                        if (f2.equals(f1)){
                            check = false;
                            break;
                        }
                    }
                    if (check && infoFile(f2, type)){
                        System.out.println(operation + f2.getName());
                    }
                }
                oldList = dir.listFiles();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            time--;
            if (time == 0) {
                System.out.println("Monitoring is stopped.");
                break;
            }
        }
    }

    private boolean infoFile (File file, String type) {
        String typeFile = file.getName().substring(file.getName().lastIndexOf('.') + 1, file.getName().length());
        return (typeFile.equals(type) || type == null);
    }

    public void setName(String[] name){
        this.name = name;
    }

    public String[] getName() {
        return name;
    }
}
