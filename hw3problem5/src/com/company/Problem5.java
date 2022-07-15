package com.company;

import java.util.Scanner;

// Find factorial of a number.
// The factorial of a positive number n is given by:
// factorial of n, (n!) = 1 * 2 * 3 * 4 * ... * n


class Problem5 {

  public static void main(String[] args) {
    int num;
    System.out.println("Please enter your number: ");
    Scanner keyboard = new Scanner(System.in);
    num = keyboard.nextInt();
    long factorial = 1;
    int i;
    for (i = 1; i < num + 1; i++) {
      factorial *= i;
    }
    System.out.println("Factorial of " + num + " is: " + factorial + ". ");
    keyboard.close();
  }
}
