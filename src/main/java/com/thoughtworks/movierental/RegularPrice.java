package com.thoughtworks.movierental;

public class RegularPrice implements Price{

    @Override
    public double amount(int daysRented) {
        double amount = 0;
        amount += 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}