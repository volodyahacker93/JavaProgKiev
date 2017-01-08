package Lection5_6.Task8;

public class Task implements Runnable {

    private InFile file;
    private String text;

    public Task(InFile file, String text) {
        this.file = file;
        this.text = text;
    }

    @Override
    public void run() {
        file.write(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
