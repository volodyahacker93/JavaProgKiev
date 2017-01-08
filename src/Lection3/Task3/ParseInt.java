package Lection3.Task3;

public class ParseInt{

    public static int parse (String value) throws ParseIntException {
        int num = 0;
        int start = 0;

        if (value.charAt(0) == '+' || value.charAt(0) == '-') {
            start = 1;
        }

        for (int i = start; i < value.length(); i++) {
            int ch = Character.digit(value.charAt(i), 10); // Переводим символ text.charAt(i) в числовое значение int, если ошибка - возврат -1.
            if (ch == -1) {
                throw new ParseIntException("error converting");
            }
            num = num + (int) (ch * Math.pow(10, value.length() - 1 - i));
        }
        if (value.charAt(0) == '-') {
            num = num * -1;
        }

        return num;
    }
}
