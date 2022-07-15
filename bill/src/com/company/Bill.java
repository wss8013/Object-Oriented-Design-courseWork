package com.company;

import java.util.Scanner;

public class Bill {

  public static void main(String[] args) {
    // Creat a scanner object
    Scanner input = new Scanner(System.in);
    // Ask user for input
    System.out.println("Input name of item 1: ");
    String item1 = input.nextLine();
    System.out.println("Input quantity of item 1: ");
    int quantity1 = input.nextInt();
    System.out.println("Input price of item 1: ");
    float price1 = input.nextFloat();
    input.nextLine();
    System.out.println("Input name of item 2: ");
    String item2 = input.nextLine();
    System.out.println("Input quantity of item 2: ");
    int quantity2 = input.nextInt();
    System.out.println("Input price of item 2: ");
    float price2 = input.nextFloat();
    input.nextLine();
    System.out.println("Input name of item 3: ");
    String item3 = input.nextLine();
    System.out.println("Input quantity of item 3: ");
    int quantity3 = input.nextInt();
    System.out.println("Input price of item 3: ");
    float price3 = input.nextFloat();
    float total1 = quantity1 * price1;
    float total2 = quantity2 * price2;
    float total3 = quantity3 * price3;
    float subtotal = total1 + total2 + total3;
    double tax = subtotal * 0.0625;
    double total = subtotal + tax;
    System.out.println("Your bill:\n");
    System.out.printf("%-30s%-10s%-10s%-10s\n", "Item", "Quantity", "Price", "Total");
    System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item1, quantity1, price1, total1);
    System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item2, quantity2, price2, total2);
    System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", item3, quantity3, price3, total3);
    System.out.printf("%-30s%-10s%-10s%-10.2f\n", "Subtotal", " ", " ", subtotal);
    System.out.printf("%-30s%-10s%-10s%-10.2f\n", "6.25 percent sales tax", " ", " ", tax);
    System.out.printf("%-30s%-10s%-10s%-10.2f\n", "Total", " ", " ", total);


  }
}
