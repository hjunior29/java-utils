package io.github.hjunior29.utils;

public final class BinarySearchIntsTest {
  private BinarySearchIntsTest() {}

  public static void main(String[] args) {
    testBasic();
    testEmpty();
    testBoundaries();
    testInvalid();
    System.out.println("All tests passed successfully.");
  }

  private static void testBasic() {
    int[] arr = {1, 2, 2, 2, 3, 4, 5};
    int idx = BinarySearchInts.binarySearchInts(arr, 2);
    if (idx != 1) {
      throw new AssertionError("Expected first occurrence at index 1, got " + idx);
    }
  }

  private static void testEmpty() {
    int[] arr = {};
    int idx = BinarySearchInts.binarySearchInts(arr, 5);
    if (idx != -1) {
      throw new AssertionError("Expected -1 for empty array, got " + idx);
    }
  }

  private static void testBoundaries() {
    int[] arr = {10, 20, 30, 40};
    if (BinarySearchInts.binarySearchInts(arr, 10) != 0) {
      throw new AssertionError("Failed lower boundary");
    }
    if (BinarySearchInts.binarySearchInts(arr, 40) != 3) {
      throw new AssertionError("Failed upper boundary");
    }
  }

  private static void testInvalid() {
    boolean thrown = false;
    try {
      BinarySearchInts.binarySearchInts(null, 5);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for null array");
    }
  }
}
