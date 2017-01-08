package Lection7_8.object.Task_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Files implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private boolean isFile;
    private List<Files> list = new ArrayList<>();
    private Files fileSystem;

    public Files(String name) {
        this.name = name;
    }

    public Files(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
    }

    public void add(Files file) {
        if(!isFile) {
            if(!find(file)) {
                file.fileSystem = this;
                list.add(file);
                System.out.println("\"" + file + "\" + has been added to \"" + this + "\"");
            } else {
                System.out.println("\"" + file + "\" + is already added to \"" + file.fileSystem + "\"");
            }
        } else {
            System.out.println("Can't add \"" + file + "\" info \"" + this + "\"!");
        }
    }

    public void remove() {
        if (fileSystem != null) {
            fileSystem.list.remove(this);
            System.out.println("Deleting completed.");
            fileSystem = null;
        } else {
            System.out.println(this + " cant't be removed.");
        }
    }

    public String getPath() {
        String path = "\\" + this;
        if (fileSystem != null) {
            path = fileSystem.getPath() + path;
        }
        return path;
    }

    public boolean find(Files file) {
        if (list.contains(file)) {
            return true;
        } else {
            for (Files f : list) {
                if (f.find(file)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Files other = (Files) obj;
        return (this.getPath().equals(other.getPath()));
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(getPath()) + (isFile ? 1 : 0);
        return hash;
    }

    public void print() {
        for (Files file : list) {
            System.out.println(file.getPath());
            file.print();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
