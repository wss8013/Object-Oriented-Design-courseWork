package com.company;

import java.util.Scanner;

public class Converter {

  public static void main(String[] args) {
    //Create a Scanner object
    Scanner input = new Scanner(System.in);
    //Ask user for input
    System.out.println("Enter a number in GB: ");
    long giga = input.nextLong();
    //Close scanner
    input.close();
    // computing gibi from giga
    long gibi = (long) (giga * Math.pow(10,9)/Math.pow(2,30));
    System.out.printf("%d GB = %d Gib", giga, gibi);
    

  }
}
