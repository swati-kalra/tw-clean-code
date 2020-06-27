package com.thoughtworks.movierental;

public class ChildrenPrice implements Price{
    public static final int CHILDREN_FREQUENT_RENTER_POINT = 1;

    @Override
    public double amount(int daysRented) {
        double amount = 0;
        amount += 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return CHILDREN_FREQUENT_RENTER_POINT;
    }


}