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
        //List of available drink sizes
        String[] drinkSizes = {"Small", "Medium", "Large"};
        boolean validSize = false;

        while (!validSize) {
            System.out.println("Choose drink size:\nSmall - $2.00\nMedium - $2.50\nLarge - $3.00");
            size = scanner.nextLine();

            //Check if user input is valid size
            for (String drinkSize : drinkSizes) {
                if (size.equalsIgnoreCase(drinkSize)) {
                    validSize = true;
                    size = drinkSize; //Match capitalization with our list
                    break;
                }
            }
            if (!validSize) {
                System.out.println("Please select: Small, Medium, or Large");
            }
        }


        //List of available drink flavors
        String[] availableFlavors = {"Coke", "Pepsi", "Sprite", "Mountain Dew", "Fanta", "Dr. Pepper", "Diet Coke", "Diet Pepsi", "Coke Zero"};
        boolean validFlavor = false;

        while (!validFlavor) {
            System.out.println("Choose drink flavor:\nCoke, Pepsi, Sprite, Mountain Dew, Fanta, Dr. Pepper, Diet Coke, Diet Pepsi, Coke Zero");
            flavor = scanner.nextLine();

            //Check if user input is valid flavor
            for (String availableFlavor : availableFlavors) {
                if (flavor.equalsIgnoreCase(availableFlavor)) {
                    validFlavor = true;
                    flavor = availableFlavor; //Match capitalization with our list
                    break;
                }
            }
            if (!validFlavor) {
                System.out.println("Please choose from the available options: Coke, Pepsi, Sprite, Mountain Dew, Fanta, Dr. Pepper, Diet Coke, Diet Pepsi, Coke Zero");
            }
        }
    }
}

