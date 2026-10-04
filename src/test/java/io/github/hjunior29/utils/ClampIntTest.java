package io.github.hjunior29.utils;

/** Regression tests for bounds and invalid ranges. */
public final class ClampIntTest {
  public static void main(String[] args) {
    int[][] cases = {
      {5, 0, 10, 5}, {-1, 0, 10, 0}, {11, 0, 10, 10}, {0, 0, 10, 0}, {10, 0, 10, 10}, {8, 3, 3, 3}
    };
    for (int[] example : cases) {
      if (ClampInt.clampInt(example[0], example[1], example[2]) != example[3]) {
        throw new AssertionError("Unexpected clamped value");
      }
    }
    try {
      ClampInt.clampInt(5, 10, 0);
      throw new AssertionError("Expected reversed bounds to fail");
    } catch (IllegalArgumentException expected) {
      /* Invalid bounds are rejected. */
    }
  }
}
