package io.github.hjunior29.utils;

public class RotateStringTest {
  public static void main(String[] args) {
    testNullInput();
    testNegativeOffset();
    testEmptyString();
    testZeroOffset();
    testNormalRotation();
    testOffsetGreaterThanLength();
    testUnicodeRotation();
    System.out.println("All tests passed successfully.");
  }

  private static void testNullInput() {
    boolean thrown = false;
    try {
      RotateString.rotateString(null, 2);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for null input.");
    }
  }

  private static void testNegativeOffset() {
    boolean thrown = false;
    try {
      RotateString.rotateString("abc", -1);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for negative offset.");
    }
  }

  private static void testEmptyString() {
    String result = RotateString.rotateString("", 3);
    if (!result.isEmpty()) {
      throw new AssertionError("Expected empty string, got: " + result);
    }
  }

  private static void testZeroOffset() {
    String result = RotateString.rotateString("abc", 0);
    if (!result.equals("abc")) {
      throw new AssertionError("Expected 'abc', got: " + result);
    }
  }

  private static void testNormalRotation() {
    String result = RotateString.rotateString("abcdef", 2);
    if (!result.equals("cdefab")) {
      throw new AssertionError("Expected 'cdefab', got: " + result);
    }
  }

  private static void testOffsetGreaterThanLength() {
    String result = RotateString.rotateString("abc", 4);
    if (!result.equals("bca")) {
      throw new AssertionError("Expected 'bca', got: " + result);
    }
  }

  private static void testUnicodeRotation() {
    String result = RotateString.rotateString("😀😁😂", 1);
    if (!result.equals("😁😂😀")) {
      throw new AssertionError("Expected rotated surrogate pairs, got: " + result);
    }
  }
}
