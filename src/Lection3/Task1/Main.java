package Lection3.Task1;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("param1=value1&param2=value2&param3=value3&param1=value1&param2=value2&param3=value");
        for (int i = 0; i < 500000; i++) {
            sb.append("&param1=value1&param2=value2&param3=value3&param1=value1&param2=value2&param3=value");
        }

        long start = System.currentTimeMillis();
        Url.parsing(sb.toString());
        long finish = System.currentTimeMillis();

        System.out.println("TIME (parsing) = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        Url.pars(sb.toString());
        finish = System.currentTimeMillis();

        System.out.println("TIME (pars) = " + (finish - start) + " ms");
    }
}