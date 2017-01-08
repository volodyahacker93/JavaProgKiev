package Lection2.Task1;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000, 5.0);
        bmw.turnOn();
        ferrari.turnOn();
        final int[] speeds = new int[]{20, 60, 100};
        for (int s : speeds) {
            bmw.start(s, 0.5);
            ferrari.start(s, 1);
        }
        bmw.turnOff();
        ferrari.turnOff();
        System.out.println(bmw.getName() + ": distance - " + bmw.getMileage() +
                " km, fuel rate - " + bmw.getFuel() + " liters.");
                System.out.println(ferrari.getName() + ": distance - " +
                        ferrari.getMileage() + " km, fuel rate - " + ferrari.getFuel() + " liters.");
    }
}