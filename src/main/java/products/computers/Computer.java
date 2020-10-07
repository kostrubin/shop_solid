package products.computers;

import products.Product;
import enums.StorageType;
import filters.FilterRam;
import filters.FilterStorageType;

public abstract class Computer extends Product implements FilterRam, FilterStorageType {
    protected String model;
    protected double cpu;
    protected int coresNumber;
    protected int ram;
    protected StorageType storageType;

    public Computer(String id, int price, String brand, boolean inStock,
                    String model, double cpu, int coresNumber, int ram, StorageType storageType) {
        super(id, price, brand, inStock);
        this.model = model;
        this.cpu = cpu;
        this.coresNumber = coresNumber;
        this.ram = ram;
        this.storageType = storageType;
    }

    @Override
    public boolean filterRam(int ram) {
        return this.ram >= ram;
    }

    @Override
    public boolean filterStorageType(StorageType storageType) {
        return this.storageType == storageType;
    }
}
