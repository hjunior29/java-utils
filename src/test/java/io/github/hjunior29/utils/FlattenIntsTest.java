package io.github.hjunior29.utils;

public class FlattenIntsTest {
  public static void main(String[] args) {
    testNormalCase();
    testEmptyCase();
    testNullArguments();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCase() {
    int[][] input = {{1, 2}, {3}, {}, {4, 5, 6}};
    int[] expected = {1, 2, 3, 4, 5, 6};
    int[] result = FlattenInts.flattenInts(input);
    if (result.length != expected.length) {
      throw new AssertionError("Length mismatch");
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i] != expected[i]) {
        throw new AssertionError("Value mismatch at index " + i);
      }
    }
  }

  private static void testEmptyCase() {
    int[][] input = {};
    int[] result = FlattenInts.flattenInts(input);
    if (result.length != 0) {
      throw new AssertionError("Expected empty array");
    }
  }

  private static void testNullArguments() {
    boolean caught = false;
    try {
      FlattenInts.flattenInts(null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null sequences array");
    }
    caught = false;
    try {
      int[][] inputWithNull = {{1}, null};
      FlattenInts.flattenInts(inputWithNull);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null sub-sequence");
    }
  }
}
