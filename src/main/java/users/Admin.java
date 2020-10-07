package users;

import orders.OrdersHistory;

public class Admin extends User {
    public Admin(String login, String password, String name, String surname) {
        super(login, password, name, surname);
    }

    public void showOrdersHistory() {
        OrdersHistory.get();
    }
}
