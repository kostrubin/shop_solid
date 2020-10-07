package products;

import filters.FilterBrand;
import filters.FilterPrice;

public abstract class Product implements FilterPrice, FilterBrand {
    protected String id;
    protected int price;
    protected String brand;
    protected boolean inStock;

    public Product(String id, int price, String brand, boolean inStock) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.inStock = inStock;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public boolean filterPrice(int from, int to) {
        return price >= from && price <= to;
    }

    @Override
    public boolean filterBrand(String brand) {
        return brand.equals(this.brand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
