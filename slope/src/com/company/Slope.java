package com.company;

import java.util.Scanner;

public class Slope {

  public static void main(String[] args) {
    // Create a scanner object
    Scanner input = new Scanner(System.in);
    // Ask user for inputs
    System.out.print("Enter the x-value of the first point: ");
    float x1 = input.nextFloat();
    System.out.print("Enter the y-value of the first point: ");
    float y1 = input.nextFloat();
    System.out.print("Enter the x-value of the second point: ");
    float x2 = input.nextFloat();
    System.out.print("Enter the y-value of the second point: ");
    float y2 = input.nextFloat();
    // If the coordinates of x is equal, the line is vertical
    if (x1 == x2) {
      System.out.println("The line is vertical!");
    } else {
      float slope = (y2 - y1) / (x2 - x1);
      System.out.println("The slope of this line is: " + slope);
    }

  }
}
