package products.computers;

import enums.StorageType;
import products.computers.Computer;

public class PC extends Computer {
    private boolean hasLptCable;
    private int storagePortsNumber;

    public PC(String id, int price, String brand, boolean inStock, String model, double cpu, int coresNumber,
              int ram, StorageType storageType, boolean hasLptCable, int storagePortsNumber) {
        super(id, price, brand, inStock, model, cpu, coresNumber, ram, storageType);
        this.hasLptCable = hasLptCable;
        this.storagePortsNumber = storagePortsNumber;
    }

    public boolean isHasLptCable() {
        return hasLptCable;
    }

    public void setHasLptCable(boolean hasLptCable) {
        this.hasLptCable = hasLptCable;
    }

    public int getStoragePortsNumber() {
        return storagePortsNumber;
    }

    public void setStoragePortsNumber(int storagePortsNumber) {
        this.storagePortsNumber = storagePortsNumber;
    }

    @Override
    public String toString() {
        return "Компьютер " + brand + " " + model + ", цена: " + price + " р.";
    }
}
