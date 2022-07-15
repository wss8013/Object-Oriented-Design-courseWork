package com.company;
import java.lang.reflect.Array;
/**
 * [40 pts]
 * Design and implement an ArrayTool.class
 * - You will have an int array in this class, and this array CANNOT be visited by other class directly.
 * - You could construct this class with TWO options:
 *     - Construct without parameters -> the class will create an array of length 5
 *     - Construct with an int value -> the class will create an array of that length
 *         - If the parameter is invalid, then use 5 instead.
 * - Implement a method reverse(), which will reverse the numbers in the array.
 *     - You don't have to return anything.
 *     - For example, [1,2,3,4,5] -> [5,4,3,2,1]
 * - Implement a method set(), which allows user to modify the numbers in the array.
 *     - You don't have to return anything.
 *     - Two int parameters -- index and value.
 *     - Check the parameters, if they are invalid, then don't change anything.
 * - Implement methods decrease()
 *     - You don't have to return anything.
 *     - Without parameter -> decrease all numbers in the array by 1.
 *     - With an int value -> decrease all numbers in the array by that parameter.
 *     - Try to avoid duplicate code
 * - Implement a static method numOfTools(), return the number of ArrayTool we have created.
 *     - public static int numOfTools()
 *     - Tip: Maybe you need to declare something to count the number.
 * - Override toString()
 *     - Should return the size of the array and the numbers in it.
 *     - Format: "size: 5, [1,2,3,4,5]"
 */

public class ArrayTool {

  private int[] arr;
  private static int counter = 0;

  // constructor without parameter
  public ArrayTool() {
    this.arr = new int[5];
    counter++;
  }

  // constructor with an int value
  public ArrayTool(int length) {
    if (length <= 0) {
      length = 5;
    }
    this.arr = new int[length];
    counter++;
  }

  // reverse method
  public void reverse() {
    int i = 0;
    int j = arr.length - 1;
    int temp;
    while (i < j) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

  // set method
  public void set(int index, int value) {
    if (index >= 0 && index < arr.length) {
      this.arr[index] = value;
    }
  }

  // decrease method without parameter
  public void decrease() {
    this.decrease(1);
  }

  //decrease method with int value
  public void decrease(int j) {
    int i;
    for (i = 0; i < arr.length; i++) {
      arr[i] = arr[i] - j;
    }
  }

  //static method numOfTools
  public static int numOfTools() {
    return counter;
  }

  // override toString method
  public String toString() {
    String res = "";
    for (int i = 0; i < arr.length - 1; i++) {
      res += arr[i] + ",";
    }
    res += arr[arr.length - 1];
    // "size: 5, [1,2,3,4,5]"
    return "size: " + arr.length + ", [" + res + "]";
  }

  public static void main(String[] args) {
    //ArrayTool a = new ArrayTool();
    //for (int i = 0; i < 5; i++) {
      //a.set(i, i + 5);
    //}
//    System.out.println(a.toString());

  }
}
