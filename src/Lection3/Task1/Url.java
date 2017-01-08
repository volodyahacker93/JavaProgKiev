package Lection3.Task1;

import Lection3.Task1.CoolArray;

import java.util.HashMap;
import java.util.Map;

public class Url {

    public static Map<String, String> parsing(String url) {
        url = url + '&';
        int temp = -1;

        CoolArray<String> t = new CoolArray<>();
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '&') {
                t.add(url.substring(temp + 1, i));
                temp = i;
            }
        }
        // System.out.println(t);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < t.size(); i++) {
            String s = t.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '=') {
                    //System.out.println(s.substring(0, j) + " : " + s.substring(j + 1, s.length()));
                    map.put(s.substring(0, j), s.substring(j + 1, s.length()));
                }
            }
        }
        return map;
    }

    public static Map<String, String> pars(String value) {
        if (value != null) {
            Map<String, String> map = new HashMap<>();
            String[] temp;
            for (String str : value.split("&")) {
                temp = str.split("=");
                map.put(temp[0], temp[1]);
            }
            return map;
        }
        return null;
    }
}