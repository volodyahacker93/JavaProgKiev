package Lection2.Task1;

public class Engine {
    private double mileage;
    private boolean started;
    private double volume;
    public Engine(double mileage, double volume) {
        this.mileage = mileage;
        this.volume = volume;
    }
    public double getVolume() {
        return volume;
    }
    public double getFuelRate() {
        int rate = 0;
        if (volume >= 1.0 && volume <= 2.0) {
            rate = 10;
        } else if (volume > 2.0 && volume <= 3.0) {
            rate = 15;
        } else if (volume > 3.0 && volume <= 4.0) {
            rate = 20;
        } else if (volume > 4.0 && volume <= 5.0) {
            rate = 25;
        }
        return rate;
    }
    public double getMileage() {
        return mileage;
    }
    public void addMileage(double mileage) {
        if (started) {
            this.mileage += mileage;
        }
    }
    public boolean isStarted() {
        return started;
    }
    public void turnOn() {
        started = true;
    }
    public void turnOff() {
        started = false;
    }
}
