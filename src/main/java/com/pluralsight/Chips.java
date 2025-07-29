package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Constants.AVAILABLE_CHIPS;
import static com.pluralsight.Constants.CHIP_PRICE;

public class Chips implements Orderable {
    private String type;

    @Override
    public double getPrice() {
        return CHIP_PRICE;
    }

    @Override
    public String getDescription() {
        return "Chips: " + type;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        //List of available chips
        boolean validChips = false;

        while (!validChips) {
            System.out.println("Choose type of chips: Lays, Ruffles, Doritos, Kettle, Cheetos");
            type = scanner.nextLine();

            //Check if user input is valid chips
            for (String availableChip : AVAILABLE_CHIPS) {
                if (type.equalsIgnoreCase(availableChip)) {
                    validChips = true;
                    type = availableChip; //Match capitalization with our list
                    break;
                }
            }
            if(!validChips) {
                System.out.println("Please choose from the available options: Lays, Ruffles, Doritos, Kettle, Cheetos");
            }
        }
    }
}
