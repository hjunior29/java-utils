package io.github.hjunior29.utils;

public final class IsBlank {
  private IsBlank() {}

  public static boolean isBlank(String input) {
    if (input == null) {
      return true;
    }
    int length = input.length();
    if (length == 0) {
      return true;
    }
    for (int i = 0; i < length; i++) {
      if (!Character.isWhitespace(input.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
