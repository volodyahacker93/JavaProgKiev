package Lection7_8.object.Task_4;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Files fileSystem = new Files("c:");
        File file = new File("List.txt");

        if (!file.exists() || !file.isFile() || file.length() == 0) {
            Files file1 = new Files("file1", true);

            Files dir1 = new Files("dir1", false);
            Files dir2 = new Files("dir2", false);

            dir1.add(file1);
            dir2.add(file1);
            dir2.add(dir1);

            dir1.add(file1);
            dir2.add(dir1);
            dir1.add(file1);
            file1.add(dir1);

            fileSystem.add(dir2);
            fileSystem.print();

            Serialization.serialize(fileSystem, file);
        } else {
            fileSystem = (Files) Serialization.deserialize(file);
            fileSystem.print();
        }
    }
}
