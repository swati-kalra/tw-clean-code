package com.thoughtworks.movierental;

public class NewReleasePrice implements Price{

    @Override
    public double amount(int daysRented) {
        double amount = 0;
        amount += daysRented * 3;
        return amount;
    }
}