package com.pluralsight;

public class Toppings implements Item {
    //Meat prices based on size
    public static final double MEAT_SMALL = 1.00;
    public static final double MEAT_MEDIUM = 2.00;
    public static final double MEAT_LARGE = 3.00;

    //Cheese prices based on size
    public static final double CHEESE_SMALL = 0.75;
    public static final double CHEESE_MEDIUM = 1.50;
    public static final double CHEESE_LARGE = 2.25;

    //Extra meat price based on size
    public static final double EXTRA_MEAT_SMALL = 1.50;
    public static final double EXTRA_MEAT_MEDIUM = 2.00;
    public static final double EXTRA_MEAT_LARGE = 4.50;

    //Extra cheese price based on size
    public static final double EXTRA_CHEESE_SMALL = 1.05;
    public static final double EXTRA_CHEESE_MEDIUM = 2.10;
    public static final double EXTRA_CHEESE_LARGE = 3.15;

    @Override
    public double getPrice() {
        return 0;
    }
}
