package io.github.hjunior29.utils;

import java.util.Optional;

public final class FirstNonBlank {
  private FirstNonBlank() {}

  public static Optional<String> firstNonBlank(CharSequence... values) {
    if (values == null) {
      return Optional.empty();
    }
    for (CharSequence value : values) {
      if (value != null && !firstNonBlankIsBlankHelper(value)) {
        return Optional.of(value.toString());
      }
    }
    return Optional.empty();
  }

  private static boolean firstNonBlankIsBlankHelper(CharSequence s) {
    int length = s.length();
    if (length == 0) {
      return true;
    }
    for (int i = 0; i < length; i++) {
      if (!Character.isWhitespace(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
