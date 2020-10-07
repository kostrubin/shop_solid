package products.homeappliances;

import products.Product;

public abstract class HomeAppliances extends Product {
    protected String model;
    protected int power;
    protected double cableLength;

    public HomeAppliances(String id, int price, String brand, boolean inStock, String model,
                          int power, double cableLength) {
        super(id, price, brand, inStock);
        this.model = model;
        this.power = power;
        this.cableLength = cableLength;
    }
}
