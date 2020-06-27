package com.thoughtworks.movierental;

public class NewReleasePrice implements Price{
    public static final int NEW_RELEASE_FREQUENT_RENTER_POINT=2;
    public static final int DEFAULT_RELEASE_FREQUENT_RENTER_POINT=1;

    @Override
    public double amount(int daysRented) {
        double amount = 0;
        amount += daysRented * 3;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        if(daysRented > 1)
            return NEW_RELEASE_FREQUENT_RENTER_POINT;
        else
            return DEFAULT_RELEASE_FREQUENT_RENTER_POINT;
    }
}