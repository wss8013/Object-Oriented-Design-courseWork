package com.company;

import java.util.Scanner;

/**
 * Problem 2 [10pts] Define an integer array with length as 6, then double the element value which
 * is at odd index. Input: Integer array Output: Integer array Example: {1, 2, 3, 4, 5, 6} -> {1, 4,
 * 3, 8, 5, 12}
 */
public class Problem2 {

  public static void main(String[] args) {
    int[] numbers = new int[6];
    Scanner input = new Scanner(System.in);
    // Ask user for input
    System.out.println("Enter 6 integers: ");
    // Read user's input of 6 integer
    int i;
    for (i = 0; i < numbers.length; i++) {
      numbers[i] = input.nextInt();
    }
    System.out.print("The input array is: ");
    for (i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
    System.out.print("\nThe output array is: ");
    // Process the calculation at odd index
    for (i = 0; i < numbers.length; i++) {
      if (i % 2 != 0) {
        numbers[i] = numbers[i] * 2;
      }
      System.out.print(numbers[i] + " ");
    }
    input.close();
  }
}
