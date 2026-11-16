package io.github.hjunior29.utils;

public final class RotateInts {
  private RotateInts() {}

  public static int[] rotateInts(int[] input, int offset) {
    if (input == null) {
      throw new IllegalArgumentException("Input array cannot be null");
    }
    if (offset < 0) {
      throw new IllegalArgumentException("Offset cannot be negative");
    }
    int[] result = new int[input.length];
    if (input.length == 0) {
      return result;
    }
    int effectiveOffset = offset % input.length;
    for (int i = 0; i < input.length; i++) {
      int newIndex = (i - effectiveOffset + input.length) % input.length;
      result[newIndex] = input[i];
    }
    return result;
  }
}
