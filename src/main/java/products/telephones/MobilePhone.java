package products.telephones;

public class MobilePhone extends Telephone {
    private boolean hasColorDisplay;
    private boolean hasPolyphony;

    public MobilePhone(String id, int price, String brand, boolean inStock, String model,
                       int simSlotsNumber, boolean hasColorDisplay, boolean hasPolyphony) {
        super(id, price, brand, inStock, model, simSlotsNumber);
        this.hasColorDisplay = hasColorDisplay;
        this.hasPolyphony = hasPolyphony;
    }

    public boolean isHasColorDisplay() {
        return hasColorDisplay;
    }

    public void setHasColorDisplay(boolean hasColorDisplay) {
        this.hasColorDisplay = hasColorDisplay;
    }

    public boolean isHasPolyphony() {
        return hasPolyphony;
    }

    public void setHasPolyphony(boolean hasPolyphony) {
        this.hasPolyphony = hasPolyphony;
    }

    @Override
    public String toString() {
        return "Мобильный телефон " + brand + " " + model + ", цена: " + price + " р.";
    }
}
