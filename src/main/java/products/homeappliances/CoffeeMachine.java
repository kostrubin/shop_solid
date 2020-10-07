package products.homeappliances;

public class CoffeeMachine extends HomeAppliances {
    private int volume;
    private boolean hasMilkCooler;

    public CoffeeMachine(String id, int price, String brand, boolean inStock, String model, int power,
                         double cableLength, int volume, boolean hasMilkCooler) {
        super(id, price, brand, inStock, model, power, cableLength);
        this.volume = volume;
        this.hasMilkCooler = hasMilkCooler;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isHasMilkCooler() {
        return hasMilkCooler;
    }

    public void setHasMilkCooler(boolean hasMilkCooler) {
        this.hasMilkCooler = hasMilkCooler;
    }

    @Override
    public String toString() {
        return "Кофемашина " + brand + " " + model + ", цена: " + price + " р.";
    }
}
