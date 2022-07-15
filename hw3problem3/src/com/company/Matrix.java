package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Problem 3 [20 pts]
 * Write a program that finds the transpose of a matrix,
 * read from a text file (Problem3.txt)
 * The first line in the file will be the dimensions.
 * The rest of lines will be the matrix
 *
 * Input:
 * No parameter needed in your method, but there is a txt file
 * you need to download and use for this problem.

 * txt file context example:
 *   3 4
 *   1 2 3 4
 *   2 3 5 2
 *   0 9 8 -2
 * (3 and 4 in the first line represent this is a 3 x 4 matrix)
 *
 * Output:
 * A string represents the transpose of a matrix.
 * Each line represents one row and one white space between each two elements.
 * Example output string:
 * 1 2 0
 * 2 3 9
 * 3 5 8
 * 4 2 -2
 */


public class Matrix {

  public static final String filename = "problem3.txt";

  public static void main(String[] args) {
    Scanner inFile = null;
    try {
      inFile = new Scanner(new FileInputStream(filename));

    } catch (FileNotFoundException e) {
      System.out.println("Hey, file not found");
      System.exit(1);
    }
    int row = inFile.nextInt();  // read the first integer in file which is 3
    int column = inFile.nextInt(); // read the second integer in file which is 4
    // Creat a new 2D array
    int[][] matrix = new int[column][row];
    int i;
    int j;

    // read each row in the file and put them into column in the matrix
    for (i = 0; i < column; i++) {
      
      for (j = 0; j < row; j++) {
        matrix[j][i] = inFile.nextInt();
        System.out.print(matrix[j][i] + " ");
      }
      System.out.println("");
    }
  }
}
