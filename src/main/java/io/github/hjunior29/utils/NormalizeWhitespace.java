package io.github.hjunior29.utils;

public final class NormalizeWhitespace {
  private NormalizeWhitespace() {
    throw new UnsupportedOperationException("Utility class");
  }

  public static String normalizeWhitespace(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }

    StringBuilder result = new StringBuilder();
    boolean inWhitespace = false;
    int length = input.length();

    for (int i = 0; i < length; i++) {
      char c = input.charAt(i);
      if (Character.isWhitespace(c)) {
        if (!inWhitespace && result.length() > 0) {
          inWhitespace = true;
        }
      } else {
        if (inWhitespace) {
          result.append(' ');
          inWhitespace = false;
        }
        result.append(c);
      }
    }

    return result.toString();
  }
}
