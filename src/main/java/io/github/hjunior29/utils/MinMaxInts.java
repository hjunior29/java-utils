package io.github.hjunior29.utils;

public final class MinMaxInts {
  private MinMaxInts() {}

  public static int[] minMaxInts(int... numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Input sequence must not be null or empty.");
    }
    int min = numbers[0];
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
      }
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    return new int[] {min, max};
  }
}
