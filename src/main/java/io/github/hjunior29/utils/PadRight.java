package io.github.hjunior29.utils;

/** String padding utilities. */
public final class PadRight {
  private PadRight() {}

  /** Pads to a code-point length without truncating; rejects null input. */
  public static String padRight(String input, int targetLength, char padChar) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null");
    }
    int currentLength = input.codePointCount(0, input.length());
    if (currentLength >= targetLength) {
      return input;
    }
    int needed = targetLength - currentLength;
    StringBuilder sb = new StringBuilder(input);
    for (int i = 0; i < needed; i++) {
      sb.append(padChar);
    }
    return sb.toString();
  }
}
