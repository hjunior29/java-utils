package io.github.hjunior29.utils;

public class IsBlankTest {
  public static void main(String[] args) {
    if (!IsBlank.isBlank(null)) {
      throw new AssertionError("Failed for null");
    }
    if (!IsBlank.isBlank("")) {
      throw new AssertionError("Failed for empty string");
    }
    if (!IsBlank.isBlank("   ")) {
      throw new AssertionError("Failed for spaces");
    }
    if (!IsBlank.isBlank("\t\n\r")) {
      throw new AssertionError("Failed for whitespace characters");
    }
    if (IsBlank.isBlank("a")) {
      throw new AssertionError("Failed for single character");
    }
    if (IsBlank.isBlank("  a  ")) {
      throw new AssertionError("Failed for padded character");
    }
    System.out.println("All tests passed successfully.");
  }
}
