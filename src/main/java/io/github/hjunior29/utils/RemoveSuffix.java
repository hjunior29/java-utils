package io.github.hjunior29.utils;

public final class RemoveSuffix {
  private RemoveSuffix() {}

  public static String removeSuffix(String str, String suffix) {
    if (str == null || suffix == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    if (str.endsWith(suffix)) {
      return str.substring(0, str.length() - suffix.length());
    }
    return str;
  }
}
