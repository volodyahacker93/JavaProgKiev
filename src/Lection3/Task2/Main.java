package Lection3.Task2;

public class Main {
    public static void main(String[] args) {

        try {
            String[] str = new String[-5];
            System.out.println(5 / 0);
            String text = null;
            System.out.println(text.charAt(5));
            text = "12evde5";
            System.out.println(Integer.parseInt(text));
            System.out.println(text.charAt(88));
        } catch (NegativeArraySizeException e) {
            System.out.println("NegativeArraySizeException: Array size can't be negative.");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException " + e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException " + e.getMessage());
        }
    }
}
