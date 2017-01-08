package Lection1.Task3;

public class Car {

    private String name;
    private Engine engine;
    private Climate climate = new Climate();

    public Car (String name) {
        this(name, 0);
    }

    public Car (String name, double mileage){
        this(name, mileage, 2);
    }

    public Car(String name, double millage, int volume) {
        this.name = name;
        engine = new Engine(millage, volume);
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return engine.getMileage();
    }

    public double getFuel() {
        return engine.getFuel();
    }

    public void turnOn(){
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }

    public void turnOff() {
        climate.turnOff();
        engine.turnOff();
    }

    public void start(int speed, double hours){
        if(engine.isStarted()){
            double distance = hours * speed;
            engine.addMileage(distance);
            engine.addFuel(distance,engine.getVolume());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }
}
