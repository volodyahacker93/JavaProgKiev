package Lection3.Task9_10;

public class Main {

    public static void main(String[] args) {
        String[] fileList = {"c:\\dir1\\1.txt", "c:\\dir1\\2.txt"};

        Monitor monitor = new Monitor(fileList, new FileEvent());   // Мониторинг файлов fileList

        //Monitor monitor = new Monitor(fileList, name -> System.out.println("File added: " + name)); // <- или так, лямбда-выражение

        monitor.start();

        /*monitor = new Monitor("c:\\3.txt", new FileEvent()); // Мониторинг одного файлов 3.txt
        monitor.start();
        monitor.monitoring("c:\\", "txt", 300); // Мониторинг каталога "c:\" файлов "txt" на протяжении 300 с.
        monitor.monitoring("c:\\", null, 500); // Мониторинг каталога "c:\" всех файлов на протяжении 500 с.*/
    }
}