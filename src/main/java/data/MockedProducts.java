package data;

import enums.*;
import products.Product;
import products.telephones.*;
import products.homeappliances.*;
import products.computers.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockedProducts {
    public static Product[] mockedProducts = {
        new CoffeeMachine(
            "HA-CM-544451",
            20000,
            "DeLonghi",
            true,
            "X232",
            85,
            1.4,
            5,
            true
        ),
        new CoffeeMachine(
            "HA-CM-999000",
            15000,
            "Nespresso",
            false,
            "K-12",
            55,
            1.2,
            2,
            false
        ),
        new WashingMachine(
            "HA-WM-235900",
            15000,
            "Electrolux",
            true,
            "Q-32",
            150,
            2,
            10,
            false,
            12
        ),
        new WashingMachine(
            "HA-WM-812302",
            9000,
            "LG",
            false,
            "AS100",
            90,
            2,
            6,
            true,
            8
        ),
        new MobilePhone(
            "T-MB-559802",
            3000,
            "Motorola",
            true,
            "E398",
            1,
            true,
            true
        ),
        new MobilePhone(
            "T-MB-521909",
            4000,
            "SonyEricsson",
            false,
            "K790i",
            2,
            true,
            true
        ),
        new Smartphone(
            "T-S-110900",
            50000,
            "Huawei",
            true,
            "P40 Pro",
            2,
            OS.ANDROID,
            6,
            8,
            6.5,
            SimType.NANO
        ),
        new Smartphone(
            "T-S-454277",
            75000,
            "Apple",
            false,
            "iPhone 11 Pro",
            1,
            OS.IOS,
            4,
            8,
            5.9,
            SimType.NANO
        ),
        new PC(
            "C-PC-541432",
            55000,
            "Lenovo",
            true,
            "SVC-2352",
            2.8,
            4,
            8,
            StorageType.HDD,
            true,
            2
        ),
        new PC(
            "C-PC-121000",
            62000,
            "HP",
            false,
            "Pavilion",
            3.8,
            6,
            16,
            StorageType.SSD,
            true,
            3
        ),
        new Laptop(
            "C-L-888912",
            110000,
            "Dell",
            false,
            "G7 7790",
            5.3,
            8,
            32,
            StorageType.SSD,
            17,
            3.2,
            true
        ),
        new Laptop(
            "C-L-209284",
            80000,
            "ASUS",
            true,
            "Zenbook 15",
            3.6,
            4,
            8,
            StorageType.SSD,
            15.6,
            1.6,
            true
        )
    };

    public List<Product> getAllProducts() {
        return Arrays
            .stream(mockedProducts)
            .collect(Collectors.toList());
    }
}
