package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String name;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final List<Rental> rentals;

    public TextStatement(String name, double totalAmount, int totalFrequentRenterPoints, List<Rental> rentals) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.rentals = rentals;
    }

    public String createStatement() {
        return textHeader() + textBody() + textFooter();
    }

    String textHeader() {
        String header = "";
        header = "Rental Record for " + name + "\n";
        return header;
    }

    String textBody() {
        String body = "";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" + rental.amount() + "\n";
        }
        return body;
    }

    String textFooter() {
        String footer = "";
        footer += "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + totalFrequentRenterPoints + " frequent renter points";
        return footer;
    }
}