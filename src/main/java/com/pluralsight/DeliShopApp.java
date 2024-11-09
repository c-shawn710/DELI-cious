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
        }
    }
}
