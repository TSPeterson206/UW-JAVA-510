package scrapfile.main;

import java.util.LinkedList;

public class Dealership {

    private static LinkedList<Car> inventory;
    private static int totalRevenue;

    static {
        inventory = new LinkedList<Car>();
        totalRevenue = 0;
    }

    public void addCar(Car car) {
        inventory.add(car);
    }

    public Car getCar(Car car) {
        final int index = inventory.indexOf(car);
        return inventory.get(index);
    }

    public LinkedList<Car> getInventory() {
        return inventory;
    }

    public void sellCar(Car car, SalesPerson salesPerson) {
        car.setAvailable(false);
        final int index = inventory.indexOf(car);
        inventory.remove(index);
        totalRevenue += car.getPrice();
        salesPerson.addSoldCar(car);
    }

    public void addNewCar(Car car) {
        inventory.add(car);
    }

}
