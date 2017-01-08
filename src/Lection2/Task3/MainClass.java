package Lection2.Task3;

public class MainClass {

    public static void main(String[] args) {
        // Phone p = new Phone(); ошибка т.к. класс абстрактный

        Nokia3310 nokia = new Nokia3310();
        System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
        nokia.call("123-45-67");
        nokia.sendSMS("567-78-89", "text message");
        System.out.println("sms count: " + nokia.getSmscount());
        System.out.println("call count: " + nokia.getCallcount());

        System.out.println("----------------------------------");

        IPhone iphone = new IPhone();
        System.out.println("IPhone screent size: " + iphone.getScreenSize());
        iphone.call("123-45-67");
        iphone.sendSMS("567-78-89", "text message");
        System.out.println("sms count: " + iphone.getSmscount());
        System.out.println("call count: " + iphone.getCallcount());

        System.out.println("----------------------------------");

        IPhone5 iphone5 = new IPhone5();
        System.out.println("IPhone screent size: " + iphone5.getScreenSize());
        iphone5.call("123-45-67");
        iphone5.sendSMS("567-78-89", "text message");
        System.out.println("sms count: " + iphone5.getSmscount());
        System.out.println("call count: " + iphone5.getCallcount());

        System.out.println("----------------------------------");

        SamsungS4 samsungS4 = new SamsungS4();
        System.out.println("SamsungS4 screent size: " + samsungS4.getScreenSize());
        samsungS4.call("123-45-67");
        samsungS4.sendSMS("567-78-89", "text message");
        System.out.println("sms count: " + samsungS4.getSmscount());
        System.out.println("call count: " + samsungS4.getCallcount());
    }

}
