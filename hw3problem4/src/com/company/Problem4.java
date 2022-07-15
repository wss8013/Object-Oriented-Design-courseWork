package com.company;
/**
 * ------------
 * [20 pts]
 * Given an array of words, return the array after trimming each word.
 * For the i-th word, the trimming rules are:
 *   * Rule 1: If the length of the word is smaller than or equal to i, or the word is "lololol", then you don't have to trim it.
 *   * Rule 2: Compare the first letter and the last letter of the word, remove the smaller one from the word.
 *             If these two letters are the same, then remove the first one.
 *             Keep doing this until the word meets rule 1.
 * ------------
 * Example 1:
 *   Input: words = ["a", "cdm", "lololol", "asd", "ooooooooooo"]
 *   Output: ["a", "dm", "lololol", "asd", "ooooo"]
 * Example 2:
 *   Input: words = []
 *   Output: []
 * Example 3:
 *   Input: words = [""]
 *   Output: [""]
 * ------------
 * Constraints:
 *   * 0 <= words.length <= 50
 *   * 0 <= words[i].length <= 100
 *   * words[i] only contains lowercase English letters
 *
 * @param words target array of words
 * @return array of words after trimming
 */
public class Problem4 {

  public static String[] trimWords(String[] words) {
    int i;
    for (i = 0; i < words.length; i++) {
      // Check rule 1
      while (words[i].length() > i + 1 && !words[i].equals("lololol")) {
        // Check rule 2
        if (words[i].charAt(0) <= words[i].charAt(words[i].length() - 1)) {
          words[i] = words[i].substring(1);
        } else {
          words[i] = words[i].substring(0, words[i].length() - 1);
        }
      }
    }
    return words;
  }


  public static void main(String[] args) {
    String[] words = {"a", "cdm", "lololol", "asd", "ooooooooooo"};
    //String[] words = {};
    //String[] words = {""};
    int i;
    String[] res = trimWords(words);
    for (i = 0; i < res.length; i++) {
      System.out.print(res[i] + "  ");
    }
  }
}

