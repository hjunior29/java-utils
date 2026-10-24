package io.github.hjunior29.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifferenceIntsTest {

  public static void main(String[] args) {
    testNormalCase();
    testDuplicatesPreservingOrder();
    testEmptyInputs();
    testAllFilteredOut();
    testNullInputs();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCase() {
    List<Integer> first = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> second = Arrays.asList(3, 5, 6);
    List<Integer> result = DifferenceInts.differenceInts(first, second);
    List<Integer> expected = Arrays.asList(1, 2, 4);

    if (!result.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + result);
    }
  }

  private static void testDuplicatesPreservingOrder() {
    List<Integer> first = Arrays.asList(1, 2, 2, 3, 1, 4);
    List<Integer> second = Arrays.asList(2);
    List<Integer> result = DifferenceInts.differenceInts(first, second);
    List<Integer> expected = Arrays.asList(1, 3, 4);

    if (!result.equals(expected)) {
      throw new AssertionError("Expected " + expected + " but got " + result);
    }
  }

  private static void testEmptyInputs() {
    List<Integer> empty = Collections.emptyList();
    List<Integer> normal = Arrays.asList(1, 2, 3);

    List<Integer> res1 = DifferenceInts.differenceInts(empty, normal);
    if (!res1.isEmpty()) {
      throw new AssertionError("Expected empty list but got " + res1);
    }

    List<Integer> res2 = DifferenceInts.differenceInts(normal, empty);
    if (!res2.equals(normal)) {
      throw new AssertionError("Expected " + normal + " but got " + res2);
    }
  }

  private static void testAllFilteredOut() {
    List<Integer> first = Arrays.asList(1, 2, 3);
    List<Integer> second = Arrays.asList(1, 2, 3, 4);
    List<Integer> result = DifferenceInts.differenceInts(first, second);

    if (!result.isEmpty()) {
      throw new AssertionError("Expected empty list but got " + result);
    }
  }

  private static void testNullInputs() {
    boolean caught = false;
    try {
      DifferenceInts.differenceInts(null, Collections.emptyList());
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null first list");
    }

    caught = false;
    try {
      DifferenceInts.differenceInts(Collections.emptyList(), null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null second list");
    }
  }
}
