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

  double amount() {
    return movie.price().amount(daysRented);
  }

  public int frequentRenter(){
    return isBonusApplicable() ? BONUSAPPLICABLE: BONUSNOTAPPLICABLE;
  }

  boolean isBonusApplicable(){
    return movie.isNewRelease() && daysRented > 1;
  }

}

