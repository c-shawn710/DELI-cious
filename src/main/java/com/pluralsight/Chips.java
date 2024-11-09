package com.pluralsight;

import java.util.Scanner;

public class Chips implements Orderable {
    private String type;

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return "Chips: " + type;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        //List of available chips
        String[] availableChips = {"Lays", "Ruffles", "Doritos", "Kettle", "Cheetos"};
        boolean validChips = false;

        while (!validChips) {
            System.out.println("Choose type of chips: Lays, Ruffles, Doritos, Kettle, Cheetos");
            type = scanner.nextLine();

            //Check if user input is valid chips
            for (String availableChip : availableChips) {
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
