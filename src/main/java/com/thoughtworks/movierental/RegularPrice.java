package com.thoughtworks.movierental;

public class RegularPrice implements Price{
    public static final int REGULAR_FREQUENT_RENTER_POINT=3;
    public static final int DEFAULT_FREQUENT_RENTER_POINT=1;

    @Override
    public double amount(int daysRented) {
        double amount = 0;
        amount += 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        if(daysRented > 1)
            return REGULAR_FREQUENT_RENTER_POINT;
        else
            return DEFAULT_FREQUENT_RENTER_POINT;
    }
}