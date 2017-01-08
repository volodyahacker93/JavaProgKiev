package Lection3.Task8;

public class FileEvent implements IFileEvent {
    @Override
    public void onFileAdded(String s) {
        System.out.println("File added: " + s);
    }
}
