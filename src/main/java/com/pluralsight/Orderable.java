package com.pluralsight;

import java.util.Scanner;

public interface Orderable {
    double getPrice();
    String getDescription();
    void customizeItem(Scanner scanner);
}
