package Lection_9.Task_2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        String url = "https://prog.kiev.ua/forum/";
        ParseHTML.saveAllPage(url, "WEBSITE");
    }
}
