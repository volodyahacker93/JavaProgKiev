package Lection_9.Task_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class ParseHTML {

    public static String getPage(String urlStr) throws IOException {
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
                    page.append(new String(buffer, 0, size));
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
        return getUrls(url);
    }

    public static List<URL> getUrls(URL url) throws IOException {
        String html = getPage(url);
        List<URL> list = new ArrayList<>();

        int positionStart;
        int positionEnd = 0;
        do {
            positionStart = html.indexOf("href\"", positionEnd);
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

    public static void saveAllPage(String urlStr, String mainDir) throws IOException {
        URL url = new URL(urlStr);
        List<URL> listUrl = new ArrayList<>();
        saveAll(url, listUrl, mainDir);
    }

    public static void saveAllPage(URL url, String mainDir) throws IOException {
        List<URL> listUrl = new ArrayList<>();
        saveAll(url, listUrl, mainDir);
    }

    private static void saveAll(URL url, List<URL> listUrl, String mainDir) throws IOException {
        List<URL> newListUrl = getUrls(url);
        for (URL newUrl : newListUrl) {
            if (!listUrl.contains(newUrl) && name(newUrl).equals(name(url))) {

                synchronized (listUrl) {
                    listUrl.add(newUrl);
                }
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            savePage(newUrl, mainDir);
                            saveAll(newUrl, listUrl, mainDir);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                };
                thread.start();
            }
        }
    }

    public static void savePage(String urlStr, String mainDir) {
        try {
            URL url = new URL(urlStr);
            savePage(url, mainDir);
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void savePage(URL url, String mainDir) {
        String path = createDirectory(url, mainDir) + "/" + namePage(url) + ".html";
        try (FileWriter writer = new FileWriter(path)) {
            String page = getPage(url);
            writer.write(page);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String createDirectory(URL url, String mainDir) {
        String path = mainDir + "/" + name(url);

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return path;
    }

    private static String name(URL url) {
        String name = url.toString();

        int start = name.indexOf("//");
        start = (start == -1) ? 0 : name.indexOf("//") + 2;

        int end = name.indexOf("/", start);
        end = (end == -1) ? name.length() : end;

        name = name.substring(start, end);
        return name;
    }

    private static String namePage(URL url) {
        String name = url.toString();
        int start = name.indexOf("//") + 2;
        name = name.substring(start);
        name = name.replace("?", "_").replace("/", "_");
        return name;
    }
}
