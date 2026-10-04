package io.github.hjunior29.utils;

/** String reversal by Unicode code points. */
public final class ReverseString {
  private ReverseString() {}

  /** Return value with its code points in reverse order. */
  public static String reverseString(String value) {
    int[] points = value.codePoints().toArray();
    StringBuilder result = new StringBuilder(value.length());
    for (int i = points.length - 1; i >= 0; i--) {
      result.appendCodePoint(points[i]);
    }
    return result.toString();
  }
}
