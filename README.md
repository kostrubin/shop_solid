# Консольный интернет-магазин
## Принципы
Отсутствие магических чисел (например, [этот цикл](https://github.com/kostrubin/shop_solid/blob/main/src/main/java/Main.java#L91))  
DRY (например, использование метода [`getSingleValueFromInput()`](https://github.com/kostrubin/shop_solid/blob/main/src/main/java/Main.java#L39))

Примеры SOLID:
1. Класс [`Order`](https://github.com/kostrubin/shop_solid/blob/main/src/main/java/orders/Order.java) соответствует принципу Single-responsibility,
т.к. в нем предусмотрен только функционал для создания заказа и изменения его статуса
2. Структура товаров ([папка products](https://github.com/kostrubin/shop_solid/tree/main/src/main/java/products)) соответствует принципу Open-closed,
т.к. для добавления новых типов товара нет необходимости менять родительские классы
3. Структура классов товаров также соответствует принципу Liskov substitution,
потому что все наследники являются частным случаем своих предков
4. Система фильтров соответствует принципу Interface segregation,
т.к. некоторые фильтры зависят от типа товара ([`FilterRam`](https://github.com/kostrubin/shop_solid/blob/main/src/main/java/products/computers/Computer.java#L26), [`FilterStorageType`](https://github.com/kostrubin/shop_solid/blob/main/src/main/java/products/computers/Computer.java#L31)

## Функционал
* Возможность залогиниться разными пользователями
* Просмотр всех товаров
* Просмотр товаров в наличии
* Фильтрация по бренду
* Фильтрация по цене
* Добавление товара в корзину
* Просмотр корзины
* Оформление заказа
* Пополнение баланса
* Просмотр истории заказов
