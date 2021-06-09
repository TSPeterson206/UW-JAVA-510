package scrapfile.main;

import java.util.ArrayList;

public class SalesPerson {

    private String name;
    private int totalCommissions = 0;
    private ArrayList carsSold = new ArrayList();

    SalesPerson(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the totalCommissions
     */
    public int getTotalCommissions() {
        return totalCommissions;
    }

    /**
     * @return the carsSold
     */
    public ArrayList getCarsSold() {
        return carsSold;
    }

    public void addSoldCar(Car car) {
        carsSold.add(car);
        this.totalCommissions += car.getPrice() * .10;
    }
}
