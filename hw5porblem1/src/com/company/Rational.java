package com.company;
/*
Problem 1 [Rational Numbers] 50 pts

Define a class named "Rational" for rational numbers. A rational number is a number that can
be represented as the quotient of two integers. For example, 1/2, 344, 6422, and so
forth are all rational numbers. (By 1/2 and so forth, we mean the everyday meaning of
the fraction, not the integer division this expression would produce in a Java program.)

Represent rational numbers as two values of type int, one for the "numerator" and one
for the "denominator". Your class should have two instance variables of type int. Call the
class Rational.

Requirements:
A. Include a constructor with two arguments that can be used to set the instance
variables of an object to any values.

B. Also include a constructor that has only a single parameter of type int; call this
single parameter "wholeNumber" and define the constructor so that the object
will be initialized to the rational number wholeNumber/1.

C. Create a copy constructor to get a deep copy of an existed Rational object.

D. Define accessor and mutator methods as well as the methods "equals" and
"toString". You should include a method "normalize" to normalize the sign of the rational
number so that the denominator is positive and the numerator is either positive or
negative. For example, after normalization, 4/-8 would be represented the same
as -4/8. (Hints: Two rational numbers a/b and c/d are equal if a*d equals c*b.)

E. Add methods for "addition", "subtraction", "multiplication", and "division".
These methods should use a calling object and a single argument. For example,
this add method (for addition) has a calling object and one argument.

So r1.add(r2) returns the result(a Rational object) of adding the rationals r1 and r2.

Good luck!
*/

class Rational {

  // create two instance variables
  private int numerator;
  private int denominator;

  // constructor declaration of class with two arguments
  public Rational(int numerator, int denominator) {
    this.setNumerator(numerator);
    if (!this.setDenominator(denominator)) {
      // if denominator cannot be set. Default set to 1.
      this.setDenominator(1);
    }
    this.normalize();
  }

  // constructor with one parameter
  public Rational(int wholeNumber) {
    this.setNumerator(wholeNumber);
    this.setDenominator(1);
  }

  // copy of a constructor
  Rational(Rational r) {
    numerator = r.numerator;
    denominator = r.denominator;
  }

  // getter method
  public int getNumerator() {
    return this.numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  // setter method
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  // since denominator cannot be 0 so the setter method should return a boolean to let caller know
  // if the denominator has been successfully set.
  public boolean setDenominator(int denominator) {
    if (denominator == 0) {
      return false;
    }
    this.denominator = denominator;
    return true;
  }

  // normalize method
  public void normalize() {
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
  }

  // equals method
  public boolean equals(Rational a) {
    return this.denominator * a.numerator == a.denominator * this.numerator;
  }

  // toString method
  public String toString() {
    return "The numerator is: " + numerator + " ,and the denominator is: " + denominator
        + "\nThe rational number is: " + numerator + "/" + denominator;
  }

  // addition method
  public Rational add(Rational input) {
    int numerator = input.numerator * this.denominator + input.denominator * this.numerator;
    int denominator = this.denominator * input.denominator;
    return new Rational(numerator, denominator);
  }

  public Rational subtract(Rational input) {
    int numerator = input.denominator * this.numerator - input.numerator * this.denominator;
    int denominator = this.denominator * input.denominator;
    return new Rational(numerator, denominator);
  }

  public Rational multiply(Rational input) {
    return new Rational(this.numerator * input.numerator, this.denominator * input.denominator);
  }

  public Rational divide(Rational input) {
    return new Rational(this.numerator * input.denominator, this.denominator * input.numerator);
  }

}
