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

  public Movie getMovie() {
    return movie;
  }

  public double amount() {
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        return regularAmount();
      case Movie.NEW_RELEASE:
        return newReleaseAmount();
      case Movie.CHILDRENS:
        return childrenAmount();
    }
    return 0;
  }

  private double childrenAmount() {
    double amount = 0;
    amount += 1.5;
    if (daysRented > 3)
      amount += (daysRented - 3) * 1.5;
    return amount;
  }

  private double newReleaseAmount() {
    double amount = 0;
    amount += daysRented * 3;
    return amount;
  }

  private double regularAmount() {
    double amount = 0;
    amount += 2;
    if (daysRented > 2)
      amount += (daysRented - 2) * 1.5;
    return amount;
  }

  public int frequentRenter(){
    return isBonusApplicable() ? BONUSAPPLICABLE: BONUSNOTAPPLICABLE;
  }

  boolean isBonusApplicable(){
    return movie.isNewRelease() && daysRented > 1;
  }

}

