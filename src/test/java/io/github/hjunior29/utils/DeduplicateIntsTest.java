package io.github.hjunior29.utils;

import java.util.Arrays;

public class DeduplicateIntsTest {
  public static void main(String[] args) {
    testNullInput();
    testEmptyInput();
    testNoDuplicates();
    testWithDuplicates();
    testAllDuplicates();
    System.out.println("All tests passed successfully.");
  }

  private static void testNullInput() {
    boolean caught = false;
    try {
      DeduplicateInts.deduplicateInts(null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null input");
    }
  }

  private static void testEmptyInput() {
    int[] input = new int[] {};
    int[] result = DeduplicateInts.deduplicateInts(input);
    if (result.length != 0) {
      throw new AssertionError("Expected empty array output");
    }
  }

  private static void testNoDuplicates() {
    int[] input = new int[] {1, 2, 3, 4};
    int[] result = DeduplicateInts.deduplicateInts(input);
    int[] expected = new int[] {1, 2, 3, 4};
    if (!Arrays.equals(result, expected)) {
      throw new AssertionError(
          "Failed for input without duplicates. Got: " + Arrays.toString(result));
    }
  }

  private static void testWithDuplicates() {
    int[] input = new int[] {1, 2, 2, 3, 1, 4, 3, 5};
    int[] result = DeduplicateInts.deduplicateInts(input);
    int[] expected = new int[] {1, 2, 3, 4, 5};
    if (!Arrays.equals(result, expected)) {
      throw new AssertionError("Failed for input with duplicates. Got: " + Arrays.toString(result));
    }
  }

  private static void testAllDuplicates() {
    int[] input = new int[] {7, 7, 7, 7};
    int[] result = DeduplicateInts.deduplicateInts(input);
    int[] expected = new int[] {7};
    if (!Arrays.equals(result, expected)) {
      throw new AssertionError(
          "Failed for input with all identical elements. Got: " + Arrays.toString(result));
    }
  }
}
