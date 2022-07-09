package com.company;

import java.util.Scanner;

public class CheckLeapYear {

  public static void main(String[] args) {
    //Creat a Scanner object
    Scanner input = new Scanner(System.in);
    //Ask user for input
    System.out.println("Enter the year: ");
    int year = input.nextInt();
    //Close scanner
    input.close();
    //Check if the year is valid
    if (year < 1) {
      System.out.println("The input is invalid.");
      return;
    }
    //Calculate to check if the given year is leap year
    if (year % 100 != 0 && year % 4 == 0) {
      System.out.printf("%d is a leap year.", year);
    } else if (year % 100 == 0 && year % 400 == 0) {
      System.out.printf("%d is a leap year.", year);
    } else {
      System.out.printf("%d is not a leap year.", year);
    }
  }
}
