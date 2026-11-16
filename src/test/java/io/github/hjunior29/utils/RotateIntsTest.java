package io.github.hjunior29.utils;

import java.util.Arrays;

public class RotateIntsTest {
  public static void main(String[] args) {
    testNormalRotation();
    testZeroOffset();
    testOffsetGreaterThanLength();
    testEmptyArray();
    testNullInput();
    testNegativeOffset();
    System.out.println("All RotateInts tests passed successfully.");
  }

  private static void testNormalRotation() {
    int[] input = {1, 2, 3, 4, 5};
    int[] expected = {3, 4, 5, 1, 2};
    int[] actual = RotateInts.rotateInts(input, 2);
    if (!Arrays.equals(actual, expected)) {
      throw new AssertionError(
          "Test failed: expected "
              + Arrays.toString(expected)
              + " but got "
              + Arrays.toString(actual));
    }
    if (!Arrays.equals(input, new int[] {1, 2, 3, 4, 5})) {
      throw new AssertionError("Test failed: input array was mutated");
    }
  }

  private static void testZeroOffset() {
    int[] input = {10, 20, 30};
    int[] expected = {10, 20, 30};
    int[] actual = RotateInts.rotateInts(input, 0);
    if (!Arrays.equals(actual, expected)) {
      throw new AssertionError("Test failed for zero offset");
    }
  }

  private static void testOffsetGreaterThanLength() {
    int[] input = {1, 2, 3};
    int[] expected = {2, 3, 1};
    int[] actual = RotateInts.rotateInts(input, 4);
    if (!Arrays.equals(actual, expected)) {
      throw new AssertionError("Test failed for offset greater than length");
    }
  }

  private static void testEmptyArray() {
    int[] input = {};
    int[] expected = {};
    int[] actual = RotateInts.rotateInts(input, 3);
    if (!Arrays.equals(actual, expected)) {
      throw new AssertionError("Test failed for empty array");
    }
  }

  private static void testNullInput() {
    boolean caught = false;
    try {
      RotateInts.rotateInts(null, 1);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Test failed: expected IllegalArgumentException for null input");
    }
  }

  private static void testNegativeOffset() {
    boolean caught = false;
    try {
      RotateInts.rotateInts(new int[] {1, 2}, -1);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError(
          "Test failed: expected IllegalArgumentException for negative offset");
    }
  }
}
