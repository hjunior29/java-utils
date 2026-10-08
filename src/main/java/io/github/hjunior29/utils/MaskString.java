package io.github.hjunior29.utils;

public final class MaskString {
  private MaskString() {}

  public static String maskString(String input, int n) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null");
    }
    if (n < 0) {
      throw new IllegalArgumentException("N cannot be negative");
    }
    int codePointCount = input.codePointCount(0, input.length());
    if (n >= codePointCount) {
      return input;
    }
    int unmaskedStartIndex = input.offsetByCodePoints(0, codePointCount - n);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < unmaskedStartIndex; ) {
      int codePoint = input.codePointAt(i);
      sb.append('*');
      i += Character.charCount(codePoint);
    }
    sb.append(input.substring(unmaskedStartIndex));
    return sb.toString();
  }
}
