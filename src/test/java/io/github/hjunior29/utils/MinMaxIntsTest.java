package io.github.hjunior29.utils;

public final class MinMaxIntsTest {
  private MinMaxIntsTest() {}

  public static void main(String[] args) {
    testSingleElement();
    testMultipleElements();
    testNegativeNumbers();
    testMixedRange();
    testEmptyInputNull();
    testEmptyInputArray();
    System.out.println("All tests passed successfully.");
  }

  private static void testSingleElement() {
    int[] result = MinMaxInts.minMaxInts(42);
    if (result.length != 2 || result[0] != 42 || result[1] != 42) {
      throw new AssertionError("Failed single element test.");
    }
  }

  private static void testMultipleElements() {
    int[] result = MinMaxInts.minMaxInts(5, 1, 9, 3, 7);
    if (result.length != 2 || result[0] != 1 || result[1] != 9) {
      throw new AssertionError("Failed multiple elements test.");
    }
  }

  private static void testNegativeNumbers() {
    int[] result = MinMaxInts.minMaxInts(-10, -3, -25, -1);
    if (result.length != 2 || result[0] != -25 || result[1] != -1) {
      throw new AssertionError("Failed negative numbers test.");
    }
  }

  private static void testMixedRange() {
    int[] result = MinMaxInts.minMaxInts(-5, 0, 5);
    if (result.length != 2 || result[0] != -5 || result[1] != 5) {
      throw new AssertionError("Failed mixed range test.");
    }
  }

  private static void testEmptyInputNull() {
    boolean caught = false;
    try {
      MinMaxInts.minMaxInts((int[]) null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Failed empty input null test: expected exception.");
    }
  }

  private static void testEmptyInputArray() {
    boolean caught = false;
    try {
      MinMaxInts.minMaxInts(new int[0]);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Failed empty input array test: expected exception.");
    }
  }
}
