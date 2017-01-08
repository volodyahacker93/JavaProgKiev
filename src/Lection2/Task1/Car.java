package Lection2.Task1;

public class Car {
    private String name;
    private Engine engine;
    private Climate climate = new Climate();
    private double fuel;
    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 1.0);
    }
    public Car(String name, double mileage, double volume) {
        this.name = name;
        engine = new Engine(mileage, volume);
    }
    public String getName() {
        return name;
    }
    public double getMileage() {
        return engine.getMileage();
    }
    public double getFuel() {
        return fuel;
    }
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperture(21);
    }
    public void turnOff() {
        engine.turnOff();
        climate.turnOff();
    }
    public void start(int speed, double hours) {
        if (engine.isStarted()) {
            double distance = hours * speed;
            engine.addMileage(distance);
            fuel += distance * engine.getFuelRate() / 100;
        }
    }
}