package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CustomerTest {
    Customer customer;

    @Before
    public void setup(){
        customer = new Customer("Swati");
        customer.addRental(new Rental(new Movie("KKKG", 0), 4));
        customer.addRental(new Rental(new Movie("KKHH", 1), 3));
        customer.addRental(new Rental(new Movie("KHNH", 2), 2));
    }

    @Test
    public void testStatementGeneration(){
        String actualStatement = customer.statement();
        String expectedStatement = "Rental Record for Swati\n" +
                "\tKKKG\t5.0\n" +
                "\tKKHH\t9.0\n" +
                "\tKHNH\t1.5\n" +
                "Amount owed is 15.5\n" +
                "You earned 6 frequent renter points";
        assertThat(expectedStatement, is(actualStatement));
    }

    @Test
    public void testHTMLStatementGeneration(){
        String actualStatement = customer.htmlStatement();
        String expectedStatement = "<h1>Rental Record for <b>Swati</b></h1><br/>" +
                "KKKG 5.0<br/>" +
                "KKHH 9.0<br/>" +
                "KHNH 1.5<br/>" +
                "Amount owed is <b>15.5</b><br/>" +
                "You earned <b>6</b> frequent renter points<br/>";
        assertThat(expectedStatement, is(actualStatement));
    }

}