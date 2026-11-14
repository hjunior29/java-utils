package io.github.hjunior29.utils;

public final class ToCamelCase {

  private ToCamelCase() {}

  public static String toCamelCase(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }

    String[] parts = input.split("_");
    StringBuilder result = new StringBuilder();
    boolean firstSegment = true;

    for (String part : parts) {
      if (part.isEmpty()) {
        continue;
      }

      if (firstSegment) {
        result.append(part.toLowerCase());
        firstSegment = false;
      } else {
        result.append(Character.toUpperCase(part.charAt(0)));
        if (part.length() > 1) {
          result.append(part.substring(1).toLowerCase());
        }
      }
    }

    return result.toString();
  }
}
