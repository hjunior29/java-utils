package io.github.hjunior29.utils;

public class SumDigitsTest {
  public static void main(String[] args) {
    testZero();
    testSingleDigit();
    testMultipleDigits();
    testNegativeInput();
    System.out.println("All tests passed successfully.");
  }

  private static void testZero() {
    int result = SumDigits.sumDigits(0);
    if (result != 0) {
      throw new AssertionError("Expected 0 for input 0, got " + result);
    }
  }

  private static void testSingleDigit() {
    int result = SumDigits.sumDigits(7);
    if (result != 7) {
      throw new AssertionError("Expected 7 for input 7, got " + result);
    }
  }

  private static void testMultipleDigits() {
    int result = SumDigits.sumDigits(12345);
    if (result != 15) {
      throw new AssertionError("Expected 15 for input 12345, got " + result);
    }
  }

  private static void testNegativeInput() {
    boolean threw = false;
    try {
      SumDigits.sumDigits(-5);
    } catch (IllegalArgumentException e) {
      threw = true;
    }
    if (!threw) {
      throw new AssertionError("Expected IllegalArgumentException for negative input");
    }
  }
}
