package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testStatementGeneration(){
        Customer customer = new Customer("Swati");
        customer.addRental(new Rental(new Movie("KKKG", 0), 4));
        customer.addRental(new Rental(new Movie("KKHH", 1), 3));
        customer.addRental(new Rental(new Movie("KHNH", 2), 2));

        String actualStatement = customer.statement();
        String expectedStatement = "Rental Record for Swati\n" +
                "\tKKKG\t5.0\n" +
                "\tKKHH\t9.0\n" +
                "\tKHNH\t1.5\n" +
                "Amount owed is 15.5\n" +
                "You earned 4 frequent renter points";
        Assert.assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void testHTMLStatementGeneration(){
        Customer customer = new Customer("Swati");
        customer.addRental(new Rental(new Movie("KKKG", 0), 4));
        customer.addRental(new Rental(new Movie("KKHH", 1), 3));
        customer.addRental(new Rental(new Movie("KHNH", 2), 2));

        String actualStatement = customer.htmlStatement();
        String expectedStatement = "<h1>Rental Record for <b>Swati</b></h1><br/>" +
                "KKKG 5.0<br/>" +
                "KKHH 9.0<br/>" +
                "KHNH 1.5<br/>" +
                "Amount owed is <b>15.5</b><br/>" +
                "You earned <b>4</b> frequent renter points<br/>";
        Assert.assertEquals(expectedStatement, actualStatement);
    }

}