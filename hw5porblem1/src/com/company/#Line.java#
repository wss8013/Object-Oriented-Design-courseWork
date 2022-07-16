package com.company;
/**
 *  In this problem, you will be using the Rational class.
 *  The goal is to design a class called Line which represents a line on a plane.
 *  Recall that the equation for a line can be written as y = rx + q, where r and q, both rational numbers, are the slope and intercept respectively.
 *  Now, given a point p = (a,b), where a and b are rational numbers,we would like to know if p is on the line.
 *  Fortunately, the method for doing so is easy: just plug in a for x and see if y = b or not. For example, consider the line y = 1/3(x) + 1.
 *  The point p = (1, 2) is not on the line (the line does not pass through it) since setting x = 1 and computing y = 1/3 * 1 + 1 we get 4/3 != 2.
 *  On the other hand, the point p = (3, 2) is on the line since y = 1/3 * 3 + 1 = 2.
 *     Required methods are
 *  *  A copy constructor
 *
 *  *  A constructor Line(Rational, Rational),
 *
 *  *  A pair of accessors getSlope() and getIntercept(),
 *
 *  *  A pair of mutators setSlope(Rational) and setIntercept(Rational),
 *
 *  *  A method includes(Rational, Rational) which takes the coordinates of a point and returns a boolean (true if the line passes through the point),
 *
 *  *  toString() which returns the equation of the line like Equation (1)–that is, “y=slopex + intercept”,
 *
 *  *  equals(Line) which returns true if and only if the two lines are identical.
 */

public class Line {

  private Rational slope;
  private Rational intercept;

  // constructor of class
  public Line(Rational slope, Rational intercept) {
    this.setSlope(slope);
    this.setIntercept(intercept);
  }

  // copy constructor
  public Line(Line l) {
    this.slope = new Rational(l.slope);
    this.intercept = new Rational(l.intercept);
  }

  public Rational getSlope() {
    return new Rational(slope);
  }

  public Rational getIntercept() {
    return new Rational(intercept);
  }

  public void setSlope(Rational slope) {
    this.slope = new Rational(slope);
  }

  public void setIntercept(Rational intercept) {
    this.intercept = new Rational(intercept);
  }

  public boolean includes(Rational x, Rational y) {
    Rational right = x.multiply(slope).add(intercept);
    return y.equals(right);
  }

  public boolean equals(Line l) {
    return this.intercept.equals(l.intercept) && this.slope.equals(l.slope);
  }

  public String toString() {
    return "y=" + slope.getNumerator() + "/" + slope.getDenominator() + "x + "
        + intercept.getNumerator() + "/" + intercept.getDenominator();
  }

  public static void main(String[] args) {
    Rational slope = new Rational(1);
    Rational intercept = new Rational(0);
    Line l = new Line(slope, intercept);
    Rational r1 = new Rational(1);
    Rational r2 = new Rational(2);
    System.out.println(l);
    System.out.println(l.includes(r1, r2));
    Rational a = new Rational(1, 2);
    Rational b = new Rational(2, 4);
    Rational res = a.multiply(b);
    System.out.println(res);
  }
}
