package io.github.hjunior29.utils;

public class RemoveSuffixTest {
  public static void main(String[] args) {
    String result1 = RemoveSuffix.removeSuffix("filename.txt", ".txt");
    if (!result1.equals("filename")) {
      throw new AssertionError("Failed normal case");
    }
    String result2 = RemoveSuffix.removeSuffix("hello", "xyz");
    if (!result2.equals("hello")) {
      throw new AssertionError("Failed when suffix not present");
    }
    String result3 = RemoveSuffix.removeSuffix("", "");
    if (!result3.equals("")) {
      throw new AssertionError("Failed empty strings case");
    }
    String result4 = RemoveSuffix.removeSuffix("abc", "abc");
    if (!result4.equals("")) {
      throw new AssertionError("Failed exact match case");
    }
    boolean caught = false;
    try {
      RemoveSuffix.removeSuffix(null, "suffix");
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Failed to catch null input");
    }
    System.out.println("All tests passed successfully.");
  }
}
