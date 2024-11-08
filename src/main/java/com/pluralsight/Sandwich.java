package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich implements Orderable {
    private String breadType;
    private String size;
    private List<String> toppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private boolean toasted;

    public Sandwich(String breadType, String size, List<String> toppings, List<String> sauces, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toppings = toppings;
        this.sauces = sauces;
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    //custom methods
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (size.equalsIgnoreCase("small")) {
            price = 5.50;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 7.00;
        } else if (size.equalsIgnoreCase("large")) {
            price = 8.50;
        }
        return price;
    }

    @Override
    public String getDescription() {
        return "Sandwich - " + size + ", " + breadType + (toasted ? ", toasted" : "") + "\nToppings: " + toppings + "\nSauces: " + sauces;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        System.out.println("Choose bread type: White, Wheat, Rye, Wrap");
        setBreadType(scanner.nextLine());

        System.out.println("Choose size: Small(4\") - $5.50, Medium(8\") - $7.00, Large(12\") - $8.50");
        setSize(scanner.nextLine());

        String topping;
        do {
            System.out.println("Add toppings: Type 'Done' to finish\n" +
                    "- Lettuce\n" +
                    "- Peppers\n" +
                    "- Onions\n" +
                    "- Tomatoes\n" +
                    "- Jalepenos\n" +
                    "- Cucumbers\n" +
                    "- Pickles\n" +
                    "- Guacamole\n" +
                    "- Mushrooms");

            topping = scanner.nextLine();
            if (!topping.equalsIgnoreCase("done")) {
                addTopping(topping);
            }
        } while (!topping.equalsIgnoreCase("done"));

        System.out.println("Add sauces: Type 'Done' to finish\n" +
                     "- Mayo\n" +
                     "- Mustard\n" +
                     "- Ketchup\n" +
                     "- Ranch\n" +
                     "- Thousand Sslands\n" +
                     "- Vinaigrette");

        String sauce;
        do {
            sauce = scanner.nextLine();
            if (!sauce.equalsIgnoreCase("done")) {
                addSauce(sauce);
            }
        } while (!sauce.equalsIgnoreCase("done"));

        System.out.println("Would you like the sandwich toasted? (yes/no):");
        setToasted(scanner.nextLine().equalsIgnoreCase("yes"));
    }
}

