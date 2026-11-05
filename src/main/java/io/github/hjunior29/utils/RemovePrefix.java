package io.github.hjunior29.utils;

public final class RemovePrefix {
  private RemovePrefix() {}

  public static String removePrefix(String str, String prefix) {
    if (str == null || prefix == null) {
      throw new IllegalArgumentException("String and prefix must not be null");
    }
    if (str.startsWith(prefix)) {
      return str.substring(prefix.length());
    }
    return str;
  }
}
