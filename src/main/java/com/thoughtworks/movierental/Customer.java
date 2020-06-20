package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String header() {
        String header = "";
        header = "Rental Record for " + getName() + "\n";
        return header;
    }

    private String footer() {
        String footer = "";
        footer += "Amount owed is " + totalAmount() + "\n";
        footer += "You earned " + totalFrequentRenters() + " frequent renter points";
        return footer;
    }

    private int totalFrequentRenters() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenter();
        }
        return frequentRenterPoints;
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" + rental.amount() + "\n";
        }
        return body;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

}
