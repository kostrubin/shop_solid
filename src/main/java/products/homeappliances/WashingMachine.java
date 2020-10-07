package products.homeappliances;

public class WashingMachine extends HomeAppliances {
    private int capacity;
    private boolean hasTimer;
    private int modesNumber;

    public WashingMachine(String id, int price, String brand, boolean inStock, String model,
                          int power, double cableLength, int capacity, boolean hasTimer, int modesNumber) {
        super(id, price, brand, inStock, model, power, cableLength);
        this.capacity = capacity;
        this.hasTimer = hasTimer;
        this.modesNumber = modesNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasTimer() {
        return hasTimer;
    }

    public void setHasTimer(boolean hasTimer) {
        this.hasTimer = hasTimer;
    }

    public int getModesNumber() {
        return modesNumber;
    }

    public void setModesNumber(int modesNumber) {
        this.modesNumber = modesNumber;
    }

    @Override
    public String toString() {
        return "Стиральная машина " + brand + " " + model + ", цена: " + price + " р.";
    }
}
