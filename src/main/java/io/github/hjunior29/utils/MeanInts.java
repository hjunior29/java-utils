package io.github.hjunior29.utils;

public final class MeanInts {
  private MeanInts() {}

  public static double meanInts(int[] values) {
    if (values == null) {
      throw new IllegalArgumentException("Input array cannot be null");
    }
    if (values.length == 0) {
      throw new IllegalArgumentException("Input array cannot be empty");
    }
    long sum = 0;
    for (int value : values) {
      sum += value;
    }
    return (double) sum / values.length;
  }
}
