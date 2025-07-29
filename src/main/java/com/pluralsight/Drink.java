package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Constants.*;

public class Drink implements Orderable {
    private String size;
    private String flavor;

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("small")) {
            return SMALL_DRINK_PRICE;
        } else if (size.equalsIgnoreCase("medium")) {
            return MEDIUM_DRINK_PRICE;
        } else if (size.equalsIgnoreCase("large")) {
            return LARGE_DRINK_PRICE;
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Drink: " + size + "\nFlavor: " + flavor;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        boolean validSize = false;

        while (!validSize) {
            System.out.println("Choose drink size:\nSmall - $2.00\nMedium - $2.50\nLarge - $3.00");
            size = scanner.nextLine();

            //Check if user input is valid size
            for (String drinkSize : DRINK_SIZES) {
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


        boolean validFlavor = false;

        while (!validFlavor) {
            System.out.println("Choose drink flavor:\nCoke, Pepsi, Sprite, Mountain Dew, Fanta, Dr. Pepper, Diet Coke, Diet Pepsi, Coke Zero");
            flavor = scanner.nextLine();

            //Check if user input is valid flavor
            for (String availableFlavor : AVAILABLE_DRINKS) {
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

