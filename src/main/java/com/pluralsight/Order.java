package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private final List<Orderable> items = new ArrayList<>();

    //Add a Sandwich to the order
    public void addSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich();
        sandwich.customizeItem(scanner);
        items.add(sandwich);
    }

    //Add a Drink to the order
    public void addDrink(Scanner scanner) {
        Drink drink = new Drink();
        drink.customizeItem(scanner);
        items.add(drink);
    }

    //Add Chips to the order
    public void addChips(Scanner scanner) {
        Chips chips = new Chips();
        chips.customizeItem(scanner);
        items.add(chips);
    }

    //Calculate total price of the order
    public double calculateTotalPrice() {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    //String summary of the order
    @Override
    public String toString() {
        //Initialize StringBuilder with a starting value
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");

        //Append each item's description
        for (Orderable item : items) {
            orderDetails.append(item.getDescription()).append("\n");
        }

        //Append each item's price
        orderDetails.append("Total price: $").append(String.format("%.2f", calculateTotalPrice()));

        //Convert StringBuilder back to a single string
        return orderDetails.toString();
    }

    //Save order to a CSV file

}
