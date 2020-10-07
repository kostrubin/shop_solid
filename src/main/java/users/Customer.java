package users;

import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int balance;

    private List<Product> cart;

    public Customer(String login, String password, String name, String surname, int balance) {
        super(login, password, name, surname);
        this.balance = balance;
        this.cart = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void showBalance() {
        System.out.println("Текущий баланс: " + getBalance() + " р.");
    }

    public void showGoodsFromCart() {
        if (cart.size() == 0) {
            System.out.println("Ваша корзина пуста");
            return;
        }

        System.out.println("Товары в вашей корзине:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.format("%d. %s\n", i + 1, cart.get(i));
        }
        System.out.println("На сумму " + calculateTotalCostOfGoodsInCart() + " р.");
    }

    public int calculateTotalCostOfGoodsInCart() {
        return cart
            .stream()
            .map(Product::getPrice)
            .reduce(0, Integer::sum);
    }

    public void increaseBalance(int value) {
        this.balance += value;
    }

    public void decreaseBalance(int value) {
        this.balance -= value;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public void emptyCart() { cart.clear(); }
}
