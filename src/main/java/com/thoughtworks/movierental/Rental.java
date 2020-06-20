package com.thoughtworks.movierental;

public class Rental {

  private final int BONUSAPPLICABLE=2;
  private final int BONUSNOTAPPLICABLE=1;

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double amount() {
    double amount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (daysRented> 2)
          amount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (daysRented > 3)
          amount += (daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }

  public int frequentRenter(){
    return isBonusApplicable() ? BONUSAPPLICABLE: BONUSNOTAPPLICABLE;
  }

  boolean isBonusApplicable(){
    return movie.isNewRelease() && daysRented > 1;
  }

}

