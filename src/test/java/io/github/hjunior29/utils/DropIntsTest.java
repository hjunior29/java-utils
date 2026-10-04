package io.github.hjunior29.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DropIntsTest {
  public static void main(String[] args) {
    testNormalCase();
    testZeroN();
    testNoIntegers();
    testEmptyInput();
    testInvalidNegativeN();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCase() {
    List<Object> input = Arrays.asList(1, "a", 2, 3, "b", 4);
    List<Integer> actual = DropInts.dropInts(input, 2);
    List<Integer> expected = Arrays.asList(3, 4);
    if (!actual.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + actual);
    }
  }

  private static void testZeroN() {
    List<Object> input = Arrays.asList(10, "test", 20);
    List<Integer> actual = DropInts.dropInts(input, 0);
    List<Integer> expected = Arrays.asList(10, 20);
    if (!actual.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + actual);
    }
  }

  private static void testNoIntegers() {
    List<Object> input = Arrays.asList("one", "two", "three");
    List<Integer> actual = DropInts.dropInts(input, 1);
    List<Integer> expected = Collections.emptyList();
    if (!actual.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + actual);
    }
  }

  private static void testEmptyInput() {
    List<Object> input = Collections.emptyList();
    List<Integer> actual = DropInts.dropInts(input, 5);
    List<Integer> expected = Collections.emptyList();
    if (!actual.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + actual);
    }
  }

  private static void testInvalidNegativeN() {
    boolean caught = false;
    try {
      DropInts.dropInts(Arrays.asList(1, 2), -1);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for negative N");
    }
  }
}
