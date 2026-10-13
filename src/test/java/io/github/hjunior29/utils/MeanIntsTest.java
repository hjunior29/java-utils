package io.github.hjunior29.utils;

public class MeanIntsTest {
  public static void main(String[] args) {
    testNormalCase();
    testSingleElement();
    testNegativeValues();
    testEmptyArrayNull();
    testEmptyArrayZeroLength();
  }

  private static void testNormalCase() {
    int[] input = {2, 4, 6, 8};
    double result = MeanInts.meanInts(input);
    if (result != 5.0) {
      throw new AssertionError("Expected 5.0 but got " + result);
    }
  }

  private static void testSingleElement() {
    int[] input = {42};
    double result = MeanInts.meanInts(input);
    if (result != 42.0) {
      throw new AssertionError("Expected 42.0 but got " + result);
    }
  }

  private static void testNegativeValues() {
    int[] input = {-10, 0, 10};
    double result = MeanInts.meanInts(input);
    if (result != 0.0) {
      throw new AssertionError("Expected 0.0 but got " + result);
    }
  }

  private static void testEmptyArrayNull() {
    boolean caught = false;
    try {
      MeanInts.meanInts(null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null array");
    }
  }

  private static void testEmptyArrayZeroLength() {
    boolean caught = false;
    try {
      MeanInts.meanInts(new int[0]);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for empty array");
    }
  }
}
