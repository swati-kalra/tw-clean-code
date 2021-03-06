package com.thoughtworks.movierental;

public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String title;
  private int priceCode;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public int getPriceCode() {
    return priceCode;
  }

  public void setPriceCode(int arg) {
    priceCode = arg;
  }

  public String getTitle() {
    return title;
  }

  boolean isNewRelease() {
    return priceCode == Movie.NEW_RELEASE;
  }

  Price price(){
    switch (getPriceCode()) {
      case Movie.REGULAR:
        return new RegularPrice();
      case Movie.NEW_RELEASE:
        return new NewReleasePrice();
      case Movie.CHILDRENS:
        return new ChildrenPrice();
      default:
        return new DefaultPrice();
    }
  }

}