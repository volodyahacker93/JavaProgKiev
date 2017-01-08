package Lection3.Task4;

public class Main {

    public static class SqrtException extends Exception{
        public SqrtException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "SqrtExeption: " + super.getMessage();
        }
    }

    public static class ZeroException extends Exception{
        public ZeroException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "ZeroException: " + super.getMessage();
        }
    }

    public static class Arithmetic extends Exception{

        public static double sqrt(double number) throws SqrtException{
            if (number < 0) {
                throw new SqrtException(number + " - negative number.");
            }
            return Math.sqrt(number);
        }

        public static double division(double num1, double num2) throws ZeroException {
            if (num2 == 0) {
                throw new ZeroException(num1 + " / " + num2 + " - division by zero.");
            }
            return num1/num2;
        }
    }

    public static void main(String[] args) {
        try {
            double[] number = {Math.PI, -Math.E};
            for (int i = 0; i < number.length; i++) {
                System.out.println("Sqrt(" + number[i] + ") = " + Arithmetic.sqrt(number[i]));
            }
        } catch (SqrtException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                System.out.println(Arithmetic.division(10, 0));
            } catch (ZeroException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
