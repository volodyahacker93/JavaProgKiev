package Lection2.Task3;

public abstract class Phone {

    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int smscount;
    protected int callcount;



    public Phone() {
        System.out.println("Phone constructor");
    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getSmscount() {
        return smscount;
    }

    public int getCallcount() {
        return callcount;
    }

    public void call(String number) {
        System.out.println("Phone class is calling " + number);
        callcount = callcount + 1;
    }

    public abstract void sendSMS(String number, String message);
}
