package data;

import users.Customer;
import users.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockedUsers {
    Customer[] mockedUsers = {
        new Customer(
            "customer1",
            "password",
            "Ivan",
            "Customer",
            100
        ),
        new Customer(
            "customer2",
            "password",
            "Oleg",
            "Customer",
            300
        ),
    };

    public Customer getUser(int index) {
        return mockedUsers[index];
    }

    public List<User> getAllUsers() {
        return Arrays
            .stream(mockedUsers)
            .collect(Collectors.toList());
    }

    public void showAvailableUsers() {
        for (int i = 0; i < mockedUsers.length; i++) {
            System.out.format("%d. %s\n", i + 1, mockedUsers[i].getLogin());
        }
    }
}
