package Lection_9_2.Task_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Stress extends Thread{

    private static String address;
    private static int number;
    private static boolean allTime;

    public Stress() {
    }

    public Stress(String http, int number, boolean allTime) {
        Stress.address = http;
        Stress.number = number;
        Stress.allTime = allTime;
    }

    public void go() {
        for(int i = 0; i < number; i++) {
            Stress thread = new Stress();
            thread.start();
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                getPage(address);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());

                if(!allTime) {
                    interrupt();
                }
            }
        }
    }

    public static String getPage(String urlStr) throws MalformedURLException, IOException {
        StringBuilder page = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream br = connection.getInputStream()) {
            byte[] buffer = new byte[10240];
            int size;
            while ((size = br.read(buffer)) >= 0) {
                page.append(new String(buffer, 0, size));
            }
        } finally {
            connection.disconnect();
        }
        return page.toString();
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Stress.address = address;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Stress.number = number;
    }

    public static boolean isAllTime() {
        return allTime;
    }

    public static void setAllTime(boolean allTime) {
        Stress.allTime = allTime;
    }
}

























