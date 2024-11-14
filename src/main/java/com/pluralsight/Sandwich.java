package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich implements Orderable {
    private String breadType;
    private String size;
    private String meat;
    private String cheese;
    private final List<String> toppings = new ArrayList<>();
    private final List<String> extraToppings = new ArrayList<>();
    private final List<String> sauces = new ArrayList<>();
    private final List<String> sideSauces = new ArrayList<>();
    private boolean toasted;
    private boolean extraMeat;
    private boolean extraCheese;

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    //custom methods
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void addExtraToppings(String topping) {
        extraToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (size.equalsIgnoreCase("small")) {
            price = 5.50;
            if (extraMeat) {
                price += 0.50;
            }
            if (extraCheese) {
                price += 0.30;
            }
        } else if (size.equalsIgnoreCase("medium")) {
            price = 7.00;
            if (extraMeat) {
                price += 1.00;
            }
            if (extraCheese) {
                price += 0.60;
            }
        } else if (size.equalsIgnoreCase("large")) {
            price = 8.50;
            if (extraMeat) {
                price += 1.50;
            }
            if (extraCheese) {
                price += 0.90;
            }
        }
        return price;
    }

    @Override
    public String getDescription() {
        return "Sandwich - " + size + ", " + breadType + (toasted ? ", toasted" : "") +
                "\nMeat: " + (meat != null ? meat : "None") +
                "\nCheese: " + (cheese != null ? cheese : "None") +
                (extraMeat ? "\nExtra Meat" : "") +
                (extraCheese ? "\nExtra Cheese" : "") +
                "\nToppings: " + toppings +
                "\nExtra Toppings: " + extraToppings +
                "\nSauces: " + sauces +
                "\nHouse Sauce: " + sideSauces;
    }

    @Override
    public void customizeItem(Scanner scanner) {
        System.out.println("Choose bread type: White, Wheat, Rye, Wrap");
        setBreadType(scanner.nextLine());

        System.out.println("Choose size: Small(4\") - $5.50, Medium(8\") - $7.00, Large(12\") - $8.50");
        setSize(scanner.nextLine());

        //Determine additional fee for extra meat/cheese depending on selected size
        double extraMeat = 0;
        double extraCheese = 0;

        if (size.equalsIgnoreCase("small")) {
            extraMeat = 0.50;
            extraCheese = 0.30;
        } else if (size.equalsIgnoreCase("medium")) {
            extraMeat = 1.00;
            extraCheese = 0.60;
        } else if (size.equalsIgnoreCase("large")) {
            extraMeat = 1.50;
            extraCheese = 0.90;
        }

        //Meat option
        System.out.println("Select protein: Or type 'none' for no meat\n" +
                "- Steak\n" +
                "- Ham\n" +
                "- Salami\n" +
                "- Roast Beef\n" +
                "- Chicken\n" +
                "- Bacon");
        String meat = scanner.nextLine();
        if (!meat.equalsIgnoreCase("none")) {
            setMeat(meat);
            //Prompt user for extra meat if meat is selected
            System.out.printf("Would you like extra meat for $%.2f? (Y / N)\n", extraMeat);
            setExtraMeat(scanner.nextLine().equalsIgnoreCase("y"));
        }

        //Cheese option
        System.out.println("Select cheese: Or type 'none' for no cheese\n" +
                "- American\n" +
                "- Provolone\n" +
                "- Cheddar\n" +
                "- Swiss");
        String cheese = scanner.nextLine();
        if (!cheese.equalsIgnoreCase("none")) {
            setCheese(cheese);
            //Prompt user for extra cheese if cheese is selected
            System.out.printf("Would you like extra cheese for $%.2f? (Y / N)\n", extraCheese);
            setExtraCheese(scanner.nextLine().equalsIgnoreCase("y"));
        }

        //Toasted?
        System.out.println("Would you like the sandwich toasted? (Y / N):");
        setToasted(scanner.nextLine().equalsIgnoreCase("y"));

        //Add toppings
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

        String topping;
        do {
            topping = scanner.nextLine();
            if (!topping.equalsIgnoreCase("done")) {
                addTopping(topping);
            }
        } while (!topping.equalsIgnoreCase("done"));

        //Extra toppings
        if (!toppings.isEmpty()) {
            System.out.println("Would you like any extra toppings?: Type 'Done' to finish");
            for (String selectedTopping : toppings) {
                System.out.println("- " + selectedTopping.substring(0, 1).toUpperCase() + selectedTopping.substring(1));
            }
        }

        do {
            topping = scanner.nextLine();
            if (!topping.equalsIgnoreCase("done")) {
                addExtraToppings(topping);
            }
        } while (!topping.equalsIgnoreCase("done"));

        // Add Sauces
        System.out.println("Add sauces: Type 'Done' to finish\n" +
                     "- Mayo\n" +
                     "- Mustard\n" +
                     "- Ketchup\n" +
                     "- Ranch\n" +
                     "- Thousand Island\n" +
                     "- Vinaigrette");

        String sauce;
        do {
            sauce = scanner.nextLine();
            if (!sauce.equalsIgnoreCase("done")) {
                addSauce(sauce);
            }
        } while (!sauce.equalsIgnoreCase("done"));

        //Ask user for sauce on side
        System.out.println("Would you like to sample our homemade sauces on the side? Type 'Done' to finish\n" +
                "1 - Au Jus\n" +
                "2 - DELI-cious sauce");

        String sideSauce;
        do {
            sideSauce = scanner.nextLine();
            switch (sideSauce) {
                case "1":
                    sideSauces.add("Au Jus");
                    System.out.println("Au Jus added as a side sauce");
                    break;
                case "2":
                    sideSauces.add("DELI-cious sauce");
                    System.out.println("DELI-cious sauce added as a side sauce");
                    break;
                case "done":
                    break;
                default:
                    System.out.println("Invalid choice. Please select '1' for Au Jus, '2' for DELI-cious, or 'Done' to finish.");
            }
        } while (!sideSauce.equalsIgnoreCase("done"));
    }
}

