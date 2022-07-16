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

class Line {

    public static void main(String[] args) {
	// write your code here
    }
}
