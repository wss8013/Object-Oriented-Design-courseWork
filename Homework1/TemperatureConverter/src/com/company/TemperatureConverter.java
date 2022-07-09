package com.company;

import java.util.Scanner;

public class TemperatureConverter {

  public static void main(String[] args) {
    //Create a Scanner object
    Scanner input = new Scanner(System.in);
    //Ask user for input
    System.out.println("Enter the temperature in Fahrenheit: ");
    int fah = input.nextInt();
    //Close scanner
    input.close();
    //Calculate celsius from Fahrenheit
    int celsius = (5 * (fah - 32)) / 9;
    System.out.printf("%d °F = %d °C",fah,celsius);


  }
}
