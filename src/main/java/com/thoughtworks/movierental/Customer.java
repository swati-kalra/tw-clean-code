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

    public String statement(){
      return new TextStatement(this.name, totalAmount(), totalFrequentRenters(), this.rentals).createStatement();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        String header = "";
        header = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";
        return header;
    }

    private String htmlBody() {
        String body = "";
        for (Rental rental : rentals) {
            body += rental.getMovie().getTitle() + " " + rental.amount() + "<br/>";
        }
        return body;
    }

    private String htmlFooter() {
        String footer = "";
        footer += "Amount owed is <b>" + totalAmount() + "</b><br/>";
        footer += "You earned <b>" + totalFrequentRenters() + "</b> frequent renter points<br/>";
        return footer;
    }

    private int totalFrequentRenters() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenter();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

}
