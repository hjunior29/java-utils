package io.github.hjunior29.utils;

public final class CommonSuffix {
  private CommonSuffix() {}

  public static String commonSuffix(String first, String second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    int firstLength = first.codePointCount(0, first.length());
    int secondLength = second.codePointCount(0, second.length());
    int commonCodePoints = 0;
    while (commonCodePoints < firstLength && commonCodePoints < secondLength) {
      int firstCharIndex = first.offsetByCodePoints(first.length(), -(commonCodePoints + 1));
      int secondCharIndex = second.offsetByCodePoints(second.length(), -(commonCodePoints + 1));
      int firstCodePoint = first.codePointAt(firstCharIndex);
      int secondCodePoint = second.codePointAt(secondCharIndex);
      if (firstCodePoint != secondCodePoint) {
        break;
      }
      commonCodePoints++;
    }
    if (commonCodePoints == 0) {
      return "";
    }
    int startIndex = first.offsetByCodePoints(first.length(), -commonCodePoints);
    return first.substring(startIndex);
  }
}
