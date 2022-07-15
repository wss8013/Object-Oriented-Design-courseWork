package com.company;

public class Symmetrical {

  public static boolean isSymmetrical(String str) {
    int i;
    for (i = 0; i < str.length() / 2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] strings = {"0220", "111", "6890", "6789876", "333256"};
    int j;
    for (j = 0; j < strings.length; j++) {
      if (isSymmetrical(strings[j])) {
        System.out.printf("%s is symmetrical.\n", strings[j]);
      } else {
        System.out.printf("%s is not symmetrical.\n", strings[j]);
      }
    }
  }
}
