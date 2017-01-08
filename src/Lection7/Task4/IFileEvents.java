package Lection7.Task4;

public interface IFileEvents {

    void onFileAdded(String path);

    void onFileDeleted(String path);
}
