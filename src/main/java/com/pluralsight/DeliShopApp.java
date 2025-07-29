package com.pluralsight;

import java.util.Scanner;

public class DeliShopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeliShopApp app = new DeliShopApp();
        app.run(scanner);
    }
    //Method to keep the app running
    public void run(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the DELI-cious Shop!\n" +
                    "Please select an option:\n" +
                    "1) New Order\n" +
                    "0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                newOrder(scanner);
            } else if (choice == 0) {
                running = false;
            } else {
                System.out.println("Please select a valid option: ");
            }
        }
        System.out.println("Thank you for visiting!\nExiting app...");
    }

    public void newOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;
        while (ordering) {
            System.out.println("1) Add Sandwich\n" +
                               "2) Add Drink\n" +
                               "3) Add Chips\n" +
                               "4) Checkout\n" +
                               "0) Cancel Order");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> order.addSandwich(scanner);
                case 2 -> order.addDrink(scanner);
                case 3 -> order.addChips(scanner);
                case 4 -> {
                    if (checkout(order, scanner)) {
                        ordering = false;
                    }
                }
                case 0 -> ordering = false;
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public boolean checkout (Order order, Scanner scanner) {
        System.out.println("=CHECKOUT=");
        System.out.println(order.toString()); //Display order summary
        System.out.println("Confirm order: \n" +
                "1) Confirm\n" +
                "0) Cancel");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                order.saveToFolder();
                System.out.println("Order confirmed.");
                return true;
            }
            case 0 -> {
                System.out.println("Order cancelled.");
                return false;
            }
            default -> System.out.println("Invalid input. Please enter '1' or confirm or '0' to cancel.");
        }
        return false;
    }
}
