import data.*;
import orders.*;
import products.*;
import users.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final List<Product> MOCKED_PRODUCTS = new MockedProducts().getAllProducts();
    static Customer CURRENT_USER = null;

    public static void main(String[] args) {
        CURRENT_USER = login();

        if (CURRENT_USER != null) {
            System.out.println("Вы вошли как " + CURRENT_USER.getLogin());
            showAvailableOptions(CURRENT_USER);
        }
    }

    public static Customer login() {
        final MockedUsers MOCKED_USERS = new MockedUsers();

        System.out.println("Добро пожаловать в магазин электроники!");
        System.out.println("Кем вы хотите войти? (0 - завершить работу)");
        MOCKED_USERS.showAvailableUsers();

        int input = getSingleValueFromInput(MOCKED_USERS.getAllUsers().size());

        if (input == 0) {
            System.out.println("Завершение работы...");
            return null;
        }

        return MOCKED_USERS.getUser(input - 1);
    }

    public static int getSingleValueFromInput(int range) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            int index;

            try {
                index = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Пожалуйста, введите число");
                continue;
            }

            if (index >= range) {
                System.out.println("Некорректное значение, попробуйте еще");
                continue;
            }

            return index;
        }
    }

    public static List<Integer> getSeveralValuesFromInput(int range) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> index = new ArrayList<>();

        while (true) {
            String inputString = scanner.nextLine();
            String[] inputs = inputString.split(" ");

            for (String input : inputs) {
                try {
                    index.add(Integer.parseInt(input) - 1);
                } catch (Exception e) {
                    System.out.println("Пожалуйста, введите число");
                }
            }

            if (index.stream().anyMatch(it -> it >= range)) {
                System.out.println("Некорректное значение, попробуйте еще");
                index.clear();
                continue;
            }

            break;
        }

        return index;
    }

    private static void printOrderedList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
    }

    private static void showAvailableOptions(User currentUser) {
        if (currentUser instanceof Customer) {
            runCustomerPanel();
        } else {
            System.out.println("Пока нам нечего вам предложить");
        }
    }

    private static void runCustomerPanel() {
        showCustomerOptions();
        int input = getSingleValueFromInput(getCustomerOptions().size());

        if (input == 0) {
            System.out.println("Выход из личного кабинета...");
            login();
        }
        if (input == 1) {
            showAllGoods();
        }
        if (input == 2) {
            showGoodsInStock();
        }
        if (input == 3) {
            showAllBrands();
        }
        if (input == 4) {
            showPriceFilter();
        }
        if (input == 5) {
            showGoodsFromCart();
        }
        if (input == 6) {
            showBalance();
        }
        if (input == 7) {
            increaseCurrentUserBalance();
        }
        if (input == 8) {
            showHistory();
        }
    }

    private static void showBalance() {
        CURRENT_USER.showBalance();
        runCustomerPanel();
    }

    private static List<String> getCustomerOptions() {
        return Arrays.asList(
            "0. Выйти",
            "1. Показать полный каталог товаров",
            "2. Показать каталог товаров в наличии",
            "3. Отфильтровать по производителю",
            "4. Отфильтровать по цене",
            "5. Перейти в корзину",
            "6. Узнать баланс",
            "7. Пополнить баланс",
            "8. История заказов"
        );
    }

    private static void showCustomerOptions() {
        System.out.println("\n===================");
        System.out.println("Выберите действие:");

        getCustomerOptions().forEach(System.out::println);
    }

    private static void showAllGoods() {
        System.out.println("Все товары:\n");

        printOrderedList(MOCKED_PRODUCTS);

        getCertainGood(MOCKED_PRODUCTS);
    }

    private static void showGoodsInStock() {
        List<Product> productsInStock = MOCKED_PRODUCTS
            .stream()
            .filter(Product::isInStock)
            .collect(Collectors.toList());

        printOrderedList(productsInStock);
        getCertainGood(productsInStock);
    }

    private static void showAllBrands() {
        List<String> brands = MOCKED_PRODUCTS
            .stream()
            .map(Product::getBrand)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Доступные производители:\n");
        printOrderedList(brands);

        System.out.println("\nВведите номера производителей через пробел:");
        List<Integer> brandIndexes = getSeveralValuesFromInput(brands.size());
        List<String> filteredBrands = new ArrayList<>();

        for (Integer brand : brandIndexes) {
            filteredBrands.add(brands.get(brand));
        }

        List<Product> filteredList = getGoodsFilteredByBrand(filteredBrands);

        printOrderedList(filteredList);
        getCertainGood(filteredList);
    }

    private static List<Product> getGoodsFilteredByBrand(List<String> brands) {
        return MOCKED_PRODUCTS
            .stream()
            .filter(it -> brands.contains(it.getBrand()))
            .collect(Collectors.toList());
    }

    private static void showPriceFilter() {
        System.out.println("Введите минимальную и максимальную сумму через пробел:");

        List<Integer> inputs = getSeveralValuesFromInput(Integer.MAX_VALUE);

        int from = inputs.get(0);
        int to = inputs.get(1);

        List<Product> filteredList = MOCKED_PRODUCTS
            .stream()
            .filter(it -> it.filterPrice(from, to))
            .collect(Collectors.toList());

        if (filteredList.size() == 0) {
            System.out.println("Ничего не найдено");
            runCustomerPanel();
        } else {
            printOrderedList(filteredList);
            getCertainGood(filteredList);
        }
    }

    private static void showChosenGood(Product product) {
        System.out.println(product);
        showGoodsOptions();

        int input = getSingleValueFromInput(getGoodsOptions().size());

        if (input == 0) {
            System.out.println("Возвращаемся...");
            runCustomerPanel();
        }

        if (input == 1) {
            if (product.isInStock()) {
                CURRENT_USER.addToCart(product);
                System.out.println("Товар добавлен в корзину");
            } else {
                System.out.println("Извините, товара нет в наличии");
            }
        }
        runCustomerPanel();
    }

    private static void getCertainGood(List<Product> productList) {
        System.out.println("\nВведите номер для перехода к товару:");
        int input = getSingleValueFromInput(MOCKED_PRODUCTS.size());

        if (input == 0) {
            System.out.println("Возвращаемся...");
            runCustomerPanel();
        }

        Product product = productList.get(input - 1);

        showChosenGood(product);
    }

    private static void showGoodsOptions() {
        System.out.println("\n===================");
        System.out.println("Выберите действие:");

        getGoodsOptions().forEach(System.out::println);
    }

    private static List<String> getGoodsOptions() {
        return Arrays.asList(
            "0. Вернуться",
            "1. Добавить в корзину"
        );
    }

    private static void showGoodsFromCart() {
        CURRENT_USER.showGoodsFromCart();

        System.out.println("\n===================");
        System.out.println("Выберите действие:");

        getCartOptions().forEach(System.out::println);;

        int input = getSingleValueFromInput(getCartOptions().size());

        if (input == 0) {
            System.out.println("Возвращаемся...");
            runCustomerPanel();
        }
        if (input == 1) {
            handleOrder();
        }
    }

    private static List<String> getCartOptions() {
        return Arrays.asList(
            "0. Вернуться",
            "1. Оформить заказ"
        );
    }

    private static void handleOrder() {
        int totalPrice = CURRENT_USER.calculateTotalCostOfGoodsInCart();
        List<Product> currentUserCart = new ArrayList<>();
        currentUserCart.addAll(CURRENT_USER.getCart());

        if (currentUserCart.size() == 0) {
            System.out.println("Ваш заказ пуст!");
        } else if (CURRENT_USER.getBalance() >= totalPrice) {
            new Order(CURRENT_USER, currentUserCart, totalPrice);
            CURRENT_USER.decreaseBalance(totalPrice);
            CURRENT_USER.emptyCart();
            System.out.println("Заказ успешно оформлен!");
        } else {
            System.out.println("У вас недостаточно средств!");
        }

        runCustomerPanel();
    }

    private static void increaseCurrentUserBalance() {
        System.out.println("Введите сумму пополнения:");
        int sum = getSingleValueFromInput(Integer.MAX_VALUE);

        CURRENT_USER.increaseBalance(sum);
        System.out.printf("Баланс пополнена на %d р.\n", sum);
        CURRENT_USER.showBalance();

        runCustomerPanel();
    }

    private static void showHistory() {
        OrdersHistory.get().forEach(System.out::println);

        runCustomerPanel();
    }
}
