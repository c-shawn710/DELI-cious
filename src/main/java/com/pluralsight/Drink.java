package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Constants.*;

public class Drink implements Orderable {
    private Size size;
    private String flavor;

    @Override
    public double getPrice() {
        if (size == null) {
            throw new IllegalStateException("Drink size is not set.");
        }
        return switch (size) {
            case SMALL -> SMALL_DRINK_PRICE;
            case MEDIUM -> MEDIUM_DRINK_PRICE;
            case LARGE -> LARGE_DRINK_PRICE;
        };
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
            String sizeInput = scanner.nextLine().trim().toUpperCase();

            try {
                size = Size.valueOf(sizeInput);
                validSize = true;
            } catch (IllegalArgumentException e ) {
                System.out.println("Invalid size. Please enter Small, Medium, or Large.");
            }
        }


        boolean validFlavor = false;

        while (!validFlavor) {
            System.out.println("Choose drink flavor:");
            for (String drink : AVAILABLE_DRINKS) {
                System.out.println("- " + drink);
            }

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

