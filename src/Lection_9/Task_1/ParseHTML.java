package Lection_9.Task_1;

/*
Вывести на экран все ссылки, которые содержатся в скачанном HTML документе.
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseHTML {

    public static String  getPage(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        return getPage(url);
    }

    public static String getPage(URL url) {
        StringBuilder page = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try (InputStream br = connection.getInputStream()) {
                byte[] buffer = new byte[5000];
                int size;
                while ((size = br.read(buffer)) >= 0) {
                    page.append(new String (buffer, 0, size));
                }
            } finally {
                connection.disconnect();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return page.toString();
    }

    public static List<URL> getUrls(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        String html = getPage(url);
        return parseHtml(html);
    }

    public static List<URL> getUrls(URL url) throws IOException {
        String html = getPage(url);
        return parseHtml(html);
    }

    public static List<URL> parseHtml(String html) throws IOException {
        List<URL> list = new ArrayList<>();

        int positionStart;
        int positionEnd = 0;
        do {
            positionStart = html.indexOf("href=\"", positionEnd);
            if (positionStart >= 0) {
                positionStart += "href\"".length();
                positionEnd = html.indexOf("\"", positionStart);
                String urlStr = html.substring(positionStart, positionEnd);

                try {
                    URL newUrl = new URL(urlStr);
                    list.add(newUrl);
                } catch (MalformedURLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } while (positionStart >= 0);

        return list;
    }
}
