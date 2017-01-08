package Lection1.Task3;

public class Engine {
    private double mileage = 0;
    private boolean started;
    private int volume;
    private double fuel;

    public Engine(double mileage, int volume) {
        this.mileage = mileage;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public double getFuel() {
        return fuel;
    }

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double mileage) {
        if (started) {
            this.mileage = this.mileage + mileage;
        }
    }

    public void addFuel(double mileage, int vol) {
        if (started) {
            this.fuel = this.fuel + (mileage*vol)/10;
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
