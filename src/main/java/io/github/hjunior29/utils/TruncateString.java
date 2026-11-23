package io.github.hjunior29.utils;

public final class TruncateString {
  private TruncateString() {}

  public static String truncateString(String input, int maxLength) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    if (maxLength < 0) {
      throw new IllegalArgumentException("Maximum length cannot be negative.");
    }
    int codePointCount = input.codePointCount(0, input.length());
    if (codePointCount <= maxLength) {
      return input;
    }
    int endIndex = input.offsetByCodePoints(0, maxLength);
    return input.substring(0, endIndex);
  }
}
