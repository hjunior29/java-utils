package io.github.hjunior29.utils;

public class TruncateStringTest {
  public static void main(String[] args) {
    testNullInput();
    testNegativeMaxLength();
    testTruncateNormal();
    testTruncateBoundaryEqual();
    testTruncateBoundarySmaller();
    testTruncateEmpty();
    testTruncateUnicode();
    System.out.println("All tests passed successfully.");
  }

  private static void testNullInput() {
    boolean caught = false;
    try {
      TruncateString.truncateString(null, 5);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null input.");
    }
  }

  private static void testNegativeMaxLength() {
    boolean caught = false;
    try {
      TruncateString.truncateString("hello", -1);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for negative max length.");
    }
  }

  private static void testTruncateNormal() {
    String result = TruncateString.truncateString("Hello, World!", 5);
    if (!result.equals("Hello")) {
      throw new AssertionError("Expected 'Hello', got '" + result + "'.");
    }
  }

  private static void testTruncateBoundaryEqual() {
    String result = TruncateString.truncateString("abc", 3);
    if (!result.equals("abc")) {
      throw new AssertionError("Expected 'abc', got '" + result + "'.");
    }
  }

  private static void testTruncateBoundarySmaller() {
    String result = TruncateString.truncateString("abcdef", 2);
    if (!result.equals("ab")) {
      throw new AssertionError("Expected 'ab', got '" + result + "'.");
    }
  }

  private static void testTruncateEmpty() {
    String result = TruncateString.truncateString("", 5);
    if (!result.equals("")) {
      throw new AssertionError("Expected empty string, got '" + result + "'.");
    }
  }

  private static void testTruncateUnicode() {
    String result = TruncateString.truncateString("123\uD83D\uDE00456", 4);
    if (!result.equals("123\uD83D\uDE00")) {
      throw new AssertionError("Expected '123\uD83D\uDE00', got '" + result + "'.");
    }
  }
}
