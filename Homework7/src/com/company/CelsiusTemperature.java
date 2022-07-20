package com.company;

public class CelsiusTemperature extends Temperature {

  private double celsius;

  public CelsiusTemperature(double celsius) {
    setInCelsius(celsius);
  }

  public CelsiusTemperature(double fahrenheit, boolean isFahrenheit) {
    if (!isFahrenheit) {
      System.out.println("IsFahrenheit has to be true.");
      throw new IllegalArgumentException();
    }
    setInCelsius(fahrenheitToCelsius(fahrenheit));
  }

  public void setInCelsius(double celsius) {
    if (celsius < ABS_ZERO_C) {
      System.out.println(" degree is lower than absolute zero.");
      throw new IllegalArgumentException();
    }
    this.celsius = celsius;
  }

  public double getCelsius() {
    return celsius;
  }

  @Override
  double inCelsius() {
    return celsius;
  }

  @Override
  double inFahrenheit() {
    return celsiusToFahrenheit(celsius);
  }

  @Override
  double inKelvin() {
    return this.celsius - ABS_ZERO_C;
  }

  @Override
  Temperature add(Temperature t) {
    if(t == null) {
      System.out.println("Cannot process null value ");
      throw new IllegalArgumentException();
    }
    return new CelsiusTemperature(t.inCelsius() + this.celsius);
  }

  @Override
  public boolean equals(Object t) {
    if(t == null) {
      return false;
    }
    if (t instanceof CelsiusTemperature) {
      return this.celsius == ((CelsiusTemperature) t).celsius;
    }
    if (t instanceof FahrenheitTemperature) {
      return ((FahrenheitTemperature) t).inCelsius() == this.celsius;
    }
    // non temperature object return false
    return false;

  }

  @Override
  public String toString() {
    return String.format("%.1f° Celsius", celsius);
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
    double diff = this.celsius - ((Temperature) o).inCelsius();
    if (diff > 0.0f) {
      return 1;
    }
    if (diff < 0.0f) {
      return -1;
    }
    return 0;
  }
}
