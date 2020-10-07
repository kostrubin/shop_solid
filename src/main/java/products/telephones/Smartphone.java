package products.telephones;

import enums.*;
import filters.*;

public class Smartphone extends Telephone implements FilterRam {
    private OS os;
    private int camerasNumber;
    private int ram;
    private double screenSize;
    private SimType simType;

    public Smartphone(String id, int price, String brand, boolean inStock, String model, int simSlotsNumber,
                      OS os, int camerasNumber, int ram, double screenSize, SimType simType) {
        super(id, price, brand, inStock, model, simSlotsNumber);
        this.os = os;
        this.camerasNumber = camerasNumber;
        this.ram = ram;
        this.screenSize = screenSize;
        this.simType = simType;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public int getCamerasNumber() {
        return camerasNumber;
    }

    public void setCamerasNumber(int camerasNumber) {
        this.camerasNumber = camerasNumber;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public SimType getSimType() {
        return simType;
    }

    public void setSimType(SimType simType) {
        this.simType = simType;
    }

    @Override
    public boolean filterRam(int ram) {
        return this.ram >= ram;
    }

    @Override
    public String toString() {
        return "Смартфон " + brand + " " + model + ", цена: " + price + " р.";
    }
}
