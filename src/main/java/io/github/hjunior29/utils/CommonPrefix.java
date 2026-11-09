package io.github.hjunior29.utils;

public final class CommonPrefix {
  private CommonPrefix() {}

  public static String commonPrefix(String first, String second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    int limit = Math.min(first.length(), second.length());
    int i = 0;
    while (i < limit) {
      int c1 = first.codePointAt(i);
      int c2 = second.codePointAt(i);
      if (c1 != c2) {
        break;
      }
      i += Character.charCount(c1);
    }
    return first.substring(0, i);
  }
}
