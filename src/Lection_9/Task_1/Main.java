package Lection_9.Task_1;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

        String url = "https://prog.kiev.ua/forum";

        String page = ParseHTML.getPage(url);
        System.out.println(page);

        System.out.println();

        List<URL> listURL = ParseHTML.getUrls(url);
        int i = 0;
        for(URL lurl : listURL) {
            System.out.println(++i + ") " + lurl.toString());
        }
    }
}
