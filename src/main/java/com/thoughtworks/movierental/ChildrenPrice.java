package com.thoughtworks.movierental;

public class ChildrenPrice implements Price{

    @Override
    public sdouble amount(int daysRented) {
        double amount = 0;
        amount += 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}