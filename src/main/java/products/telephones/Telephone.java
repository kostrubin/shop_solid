package products.telephones;

import products.Product;

public abstract class Telephone extends Product {
    protected String model;
    protected int simSlotsNumber;

    public Telephone(String id, int price, String brand, boolean inStock, String model, int simSlotsNumber) {
        super(id, price, brand, inStock);
        this.model = model;
        this.simSlotsNumber = simSlotsNumber;
    }
}
