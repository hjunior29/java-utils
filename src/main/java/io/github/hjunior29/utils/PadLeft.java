package io.github.hjunior29.utils;

public final class PadLeft {
  private PadLeft() {}

  public static String padLeft(String input, int targetLength, char padChar) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    int currentLength = input.codePointCount(0, input.length());
    if (targetLength < 0) {
      throw new IllegalArgumentException("Target length cannot be negative.");
    }
    if (currentLength >= targetLength) {
      return input;
    }
    int padCount = targetLength - currentLength;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < padCount; i++) {
      sb.append(padChar);
    }
    sb.append(input);
    return sb.toString();
  }
}
