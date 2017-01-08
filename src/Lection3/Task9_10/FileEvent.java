package Lection3.Task9_10;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEvent implements IFileEvent {

    @Override
    public void onFileAdded(File file){
        Date date = new Date(file.lastModified());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        System.out.println("File added: " + file.getPath() + ", date: " + dateFormat.format(date));
    }
}
