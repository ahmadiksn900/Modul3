package tugas1;

import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<MenuItem> items;
    private int numberOfPeople;
    private double discount;

    public Order(int numberOfPeople, double discount) {
        this.items = new ArrayList<>();
        this.numberOfPeople = numberOfPeople;
        this.discount = discount;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        //Custom Live Template
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        total -= discount; // Mengurangi diskon
        return total < 0 ? 0 : total; // Total tidak boleh negatif

    }

    public void printReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("Number of People: " + numberOfPeople);
        for (MenuItem item : items) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("Total: $%.2f%n", calculateTotal());
    }
}

public class Restaurant {
    public static void main(String[] args) {
        MenuItem pizza = new MenuItem("Pizza", 12.99);
        MenuItem burger = new MenuItem("Burger", 9.99);
        MenuItem soda = new MenuItem("Soda", 1.99);

        Order order = new Order(3, 5.00); // 3 orang, diskon $5
        order.addItem(pizza);
        order.addItem(burger);
        order.addItem(soda);

        order.printReceipt();
    }
}

