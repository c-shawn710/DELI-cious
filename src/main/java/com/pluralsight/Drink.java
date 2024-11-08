package com.pluralsight;

import java.util.Scanner;

public class Drink implements Orderable {
    private String size;
    private String flavor;

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("small")) {
            return 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            return 3.00;
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Drink: " + size + "\nFlavor: " + flavor;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        System.out.println("Choose drink size:\nSmall - $2.00\nMedium - $2.50\nLarge - $3.00");
        size = scanner.nextLine();
        System.out.println("Choose drink flavor:\nCoca-Cola, Pepsi, Sprite, Mountain Dew, Fanta, Dr. Pepper, Diet Coke, Diet Pepsi, Coke Zero");
    }
}
