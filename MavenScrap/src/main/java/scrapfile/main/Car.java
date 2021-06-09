package scrapfile.main;

public class Car {

    private int id;
    private String make;
    private int price;
    private int mileage;
    boolean available;

    Car(int id, String make, int mileage, boolean available) {
        this.id = id;
        this.make = make;
        this.price = price;
        setAvailable(false);
        setMileage(mileage);
    }

    /**
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * @param mileage the mileage to set
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return this.price;
    }
}
