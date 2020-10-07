package orders;

import enums.Status;
import products.Product;
import users.Customer;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Order {
    private final UUID id;
    private Status status;
    private final String date;
    private final Customer customer;
    private final List<Product> productList;
    private final int sum;

    public Order(Customer customer, List<Product> productList, int sum) {
        this.id = UUID.randomUUID();
        this.status = Status.CREATED;
        this.date = getCurrentLocalDateTime();
        this.customer = customer;
        this.productList = productList;
        this.sum = sum;

        OrdersHistory.addToHistory(this);
    }

    private String getCurrentLocalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return date +
            ", ID: " + id +
            ", статус: " + status +
            ", покупатель: " + customer.getLogin() +
            ", товары: " + productList +
            ", на сумму: " + sum + " р.";
    }
}
