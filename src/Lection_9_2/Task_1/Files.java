package Lection_9_2.Task_1;

import java.io.*;

public class Files {

    public static void write(String fileName, Object obj) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileName))){
            output.write(obj.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String read(String fileName) throws FileNotFoundException{
        StringBuilder sb = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))){
            String str;
            while ((str = input.readLine()) != null) {
                sb.append(str).append("\r\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sb.toString();
    }
}
