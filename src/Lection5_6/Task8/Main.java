package Lection5_6.Task8;

public class Main {

    public static void main(String[] args) {
        try {
            InFile file = new InFile("c:\\dir1\\5.txt");
            String[] someText = {"1Q ", "2W ", "3E ", "4R ", "5T ", "6Y ", "7U ", "8I ", "9O ", "0P "};

            for(String text : someText) {
                Task task = new Task(file, text);
                Thread thread = new Thread(task);
                thread.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
