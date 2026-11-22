package io.github.hjunior29.utils;

public final class RotateString {
  private RotateString() {}

  public static String rotateString(String input, int offset) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    if (offset < 0) {
      throw new IllegalArgumentException("Offset cannot be negative.");
    }
    if (input.isEmpty()) {
      return "";
    }
    int[] codePoints = input.codePoints().toArray();
    int length = codePoints.length;
    int effectiveOffset = offset % length;
    if (effectiveOffset == 0) {
      return input;
    }
    int[] rotated = new int[length];
    System.arraycopy(codePoints, effectiveOffset, rotated, 0, length - effectiveOffset);
    System.arraycopy(codePoints, 0, rotated, length - effectiveOffset, effectiveOffset);
    return new String(rotated, 0, length);
  }
}
