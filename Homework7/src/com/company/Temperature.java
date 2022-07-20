package com.company;

/**
 * Represents a temperature.
 */
public abstract class Temperature implements Comparable {

  /**
   * Absolute zero, in degrees Celsius. For our purposes, no temperature can be below this value.
   */
  double ABS_ZERO_C = -273.15f;

  /**
   * The temperature in degrees Celsius.
   *
   * @return the temperature in degrees Celsius
   */
  abstract double inCelsius();

  /**
   * The temperature in degrees Fahrenheit.
   *
   * @return the temperature in degrees Fahrenheit
   */
  abstract double inFahrenheit();

  /**
   * The temperature in degrees Kelvin.
   *
   * @return the temperature in degrees Kelvin
   */
  abstract double inKelvin();

  // you can create some getters and setters here if you need


  /**
   * Add two temperatures together and return the resulting temperature.
   *
   * @return the new temperature
   */
  abstract Temperature add(Temperature t);

  /**
   * Check two temperatures are equal.
   *
   * @param t Temperature object
   * @return boolean value indicate whether two temperature is equal
   */
  abstract public boolean equals(Object t);

  /**
   * display the temperature
   *
   * @return return a String as follows: "NN.N° Fahrenheit"
   */
  abstract public String toString();

  public static double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5.0 / 9.0;
  }

  public static double celsiusToFahrenheit(double celsius) {
    return celsius * 9.0 / 5.0 + 32;
  }
}



