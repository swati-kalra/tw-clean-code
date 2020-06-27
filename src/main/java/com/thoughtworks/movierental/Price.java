package com.thoughtworks.movierental;

public interface Price {

    public double amount(int daysRented);
    public int frequentRenterPoints(int daysRented);
}
