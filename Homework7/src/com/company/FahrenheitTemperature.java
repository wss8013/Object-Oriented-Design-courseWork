package com.company;

public class FahrenheitTemperature extends Temperature {

  private double fahrenheit;

  // constructor
  public FahrenheitTemperature(double fahrenheit) {
    setFahrenheit(fahrenheit);
  }

  public FahrenheitTemperature(double celsius, boolean isCelsius) {
    if (!isCelsius) {
      System.out.println("isCelsius has to be true.");
      throw new IllegalArgumentException();
    }
    setFahrenheit(celsiusToFahrenheit(celsius));
  }

  public void setFahrenheit(double fahrenheit) {
    // convert fahrenheit to celsius then compare to absolute zero
    // if fahrenheit is less than absolute zero
    // throw an error
    if (fahrenheitToCelsius(fahrenheit) < ABS_ZERO_C) {
      System.out.println(" degree is lower than absolute zero.");
      throw new IllegalArgumentException();
    }
    this.fahrenheit = fahrenheit;
  }

  public double getFahrenheit() {
    return fahrenheit;
  }

  @Override
  double inCelsius() {
    return fahrenheitToCelsius(this.fahrenheit);
  }

  @Override
  double inFahrenheit() {
    return this.fahrenheit;
  }

  @Override
  double inKelvin() {
    return this.inCelsius() - ABS_ZERO_C;
  }

  @Override
  Temperature add(Temperature t) {
    if (t == null) {
      System.out.println("Cannot process null value ");
      throw new IllegalArgumentException();
    }
    return new FahrenheitTemperature(t.inFahrenheit() + this.fahrenheit);
  }

  @Override
  public boolean equals(Object t) {
    if (t == null) {
      return false;
    }
    if (t instanceof CelsiusTemperature) {
      return this.fahrenheit == ((CelsiusTemperature) t).inFahrenheit();
    }
    if (t instanceof FahrenheitTemperature) {
      return ((FahrenheitTemperature) t).fahrenheit == this.fahrenheit;
    }
    // non temperature object return false
    return false;
  }

  @Override
  public String toString() {
    return String.format("%.1f° Fahrenheit", fahrenheit);
  }

  @Override
  public int compareTo(Object o) {
    if (o == null || !(o instanceof Temperature)) {
      System.out.println("Can only compare to a non-null Temperature object");
      throw new IllegalArgumentException();
    }
    // using double diff to compare with a 0.0
    // not directly converting diff to int and return diff because once the abs(diff) < 1, the
    // result is going to be inaccurate.
    double diff = this.fahrenheit - ((Temperature) o).inFahrenheit();
    if (diff > 0.0f) {
      return 1;
    }
    if (diff < 0.0f) {
      return -1;
    }
    return 0;
  }
}

