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

    @Override
    public double getPrice() {
        double price = 0;
        if (size.equals("4")) {
            price = 5.50;
        } else if (size.equals("8")) {
            price = 7.00;
        } else if (size.equals("12")) {
            price = 8.50;
        }
        return price;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void customizeItem(Scanner scanner) {

    }
}
