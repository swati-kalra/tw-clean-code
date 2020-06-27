package com.thoughtworks.movierental;

public class Rental {
  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  double amount() {
    return movie.price().amount(daysRented);
  }

  public int frequentRenter(){
    return movie.price().frequentRenterPoints(daysRented);
  }

}

