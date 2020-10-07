package products.computers;

import enums.StorageType;

public class Laptop extends Computer {
    private double screenSize;
    private double weight;
    private boolean hasWebcam;

    public Laptop(String id, int price, String brand, boolean inStock, String model, double cpu, int coresNumber,
                  int ram, StorageType storageType, double screenSize, double weight, boolean hasWebcam) {
        super(id, price, brand, inStock, model, cpu, coresNumber, ram, storageType);
        this.screenSize = screenSize;
        this.weight = weight;
        this.hasWebcam = hasWebcam;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isHasWebcam() {
        return hasWebcam;
    }

    public void setHasWebcam(boolean hasWebcam) {
        this.hasWebcam = hasWebcam;
    }

    @Override
    public String toString() {
        return "Ноутбук " + brand + " " + model + ", цена: " + price + " р.";
    }
}
