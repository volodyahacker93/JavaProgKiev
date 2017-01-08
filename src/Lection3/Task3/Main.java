package Lection3.Task3;

public class Main {

    public static void main(String[] args) {
        String[] text = new String[]{"+25016", "-2470", "-q44e5"};
        try {
            System.out.println("String -> Int: ");
            for (int i = 0; i < text.length; i++){
                System.out.println("\"" + text[i] + "\" -> " + ParseInt.parse(text[i]));
            }
        } catch (ParseIntException ex){
            System.out.println(ex.getMessage());
        }
    }
}
