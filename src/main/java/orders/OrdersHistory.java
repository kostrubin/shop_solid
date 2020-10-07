package orders;

import java.util.ArrayList;
import java.util.List;

public final class OrdersHistory {

    private static final List<Order> instance = new ArrayList<>();

    private OrdersHistory() {}

    public static List<Order> get() {
        return instance;
    }

    public static void addToHistory(Order order) {
        instance.add(order);
    }
}
