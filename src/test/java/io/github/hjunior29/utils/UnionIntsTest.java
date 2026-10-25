package io.github.hjunior29.utils;

import java.util.Arrays;

public class UnionIntsTest {

  public static void main(String[] args) {
    testNormalUnion();
    testEmptyInputs();
    testDuplicatesAndOrder();
    testNullInputs();
    System.out.println("All UnionInts tests passed successfully.");
  }

  private static void testNormalUnion() {
    int[] first = {1, 2, 3};
    int[] second = {3, 4, 5};
    int[] expected = {1, 2, 3, 4, 5};
    int[] actual = UnionInts.unionInts(first, second);
    if (!Arrays.equals(expected, actual)) {
      throw new AssertionError(
          "Expected " + Arrays.toString(expected) + " but got " + Arrays.toString(actual));
    }
  }

  private static void testEmptyInputs() {
    int[] first = {};
    int[] second = {};
    int[] expected = {};
    int[] actual = UnionInts.unionInts(first, second);
    if (!Arrays.equals(expected, actual)) {
      throw new AssertionError("Expected empty array but got " + Arrays.toString(actual));
    }

    int[] nonEmpty = {1, 2};
    int[] result1 = UnionInts.unionInts(nonEmpty, first);
    if (!Arrays.equals(nonEmpty, result1)) {
      throw new AssertionError(
          "Expected " + Arrays.toString(nonEmpty) + " but got " + Arrays.toString(result1));
    }

    int[] result2 = UnionInts.unionInts(first, nonEmpty);
    if (!Arrays.equals(nonEmpty, result2)) {
      throw new AssertionError(
          "Expected " + Arrays.toString(nonEmpty) + " but got " + Arrays.toString(result2));
    }
  }

  private static void testDuplicatesAndOrder() {
    int[] first = {5, 1, 5, 2};
    int[] second = {2, 3, 1, 6};
    int[] expected = {5, 1, 2, 3, 6};
    int[] actual = UnionInts.unionInts(first, second);
    if (!Arrays.equals(expected, actual)) {
      throw new AssertionError(
          "Expected " + Arrays.toString(expected) + " but got " + Arrays.toString(actual));
    }
  }

  private static void testNullInputs() {
    boolean exceptionThrown = false;
    try {
      UnionInts.unionInts(null, new int[] {1, 2});
    } catch (IllegalArgumentException e) {
      exceptionThrown = true;
    }
    if (!exceptionThrown) {
      throw new AssertionError("Expected IllegalArgumentException for null first array.");
    }

    exceptionThrown = false;
    try {
      UnionInts.unionInts(new int[] {1, 2}, null);
    } catch (IllegalArgumentException e) {
      exceptionThrown = true;
    }
    if (!exceptionThrown) {
      throw new AssertionError("Expected IllegalArgumentException for null second array.");
    }
  }
}
