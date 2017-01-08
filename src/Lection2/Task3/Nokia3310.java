package Lection2.Task3;

 class Nokia3310 extends Phone {

    public Nokia3310() {
        System.out.println("Nokia3310 constructor");

        touch = false;
        hasWifi = false;
        screenSize = 2;
    }

    @Override
    public void call(String number) {
        super.call(number);
        System.out.println("Nokia3310 class is calling " + number);
        callcount++;
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("Nokia3310 class is sending sms " + message + " to " + number);
        smscount++;
    }
}
