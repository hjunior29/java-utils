package io.github.hjunior29.utils;

public class ChunkIntsTest {
  public static void main(String[] args) {
    testNormalSplitting();
    testExactMultiple();
    testSingleElementSize();
    testEmptySequence();
    testInvalidSize();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalSplitting() {
    int[] input = {1, 2, 3, 4, 5};
    int[][] result = ChunkInts.chunkInts(input, 2);
    if (result.length != 3) {
      throw new AssertionError("Expected 3 chunks");
    }
    if (result[0].length != 2 || result[0][0] != 1 || result[0][1] != 2) {
      throw new AssertionError("First chunk incorrect");
    }
    if (result[1].length != 2 || result[1][0] != 3 || result[1][1] != 4) {
      throw new AssertionError("Second chunk incorrect");
    }
    if (result[2].length != 1 || result[2][0] != 5) {
      throw new AssertionError("Third chunk incorrect");
    }
  }

  private static void testExactMultiple() {
    int[] input = {10, 20, 30, 40};
    int[][] result = ChunkInts.chunkInts(input, 2);
    if (result.length != 2) {
      throw new AssertionError("Expected 2 chunks");
    }
    if (result[0].length != 2 || result[0][0] != 10 || result[0][1] != 20) {
      throw new AssertionError("First chunk incorrect");
    }
    if (result[1].length != 2 || result[1][0] != 30 || result[1][1] != 40) {
      throw new AssertionError("Second chunk incorrect");
    }
  }

  private static void testSingleElementSize() {
    int[] input = {7, 8, 9};
    int[][] result = ChunkInts.chunkInts(input, 1);
    if (result.length != 3) {
      throw new AssertionError("Expected 3 chunks");
    }
    if (result[0].length != 1 || result[0][0] != 7) {
      throw new AssertionError("First chunk incorrect");
    }
    if (result[1].length != 1 || result[1][0] != 8) {
      throw new AssertionError("Second chunk incorrect");
    }
    if (result[2].length != 1 || result[2][0] != 9) {
      throw new AssertionError("Third chunk incorrect");
    }
  }

  private static void testEmptySequence() {
    int[] input = {};
    int[][] result = ChunkInts.chunkInts(input, 3);
    if (result.length != 0) {
      throw new AssertionError("Expected empty result for empty input");
    }
  }

  private static void testInvalidSize() {
    int[] input = {1, 2, 3};
    boolean threwZero = false;
    try {
      ChunkInts.chunkInts(input, 0);
    } catch (IllegalArgumentException e) {
      threwZero = true;
    }
    if (!threwZero) {
      throw new AssertionError("Expected exception for size zero");
    }
    boolean threwNegative = false;
    try {
      ChunkInts.chunkInts(input, -5);
    } catch (IllegalArgumentException e) {
      threwNegative = true;
    }
    if (!threwNegative) {
      throw new AssertionError("Expected exception for negative size");
    }
  }
}
