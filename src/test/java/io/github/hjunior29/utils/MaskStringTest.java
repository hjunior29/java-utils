package io.github.hjunior29.utils;

public final class MaskStringTest {
  private MaskStringTest() {}

  public static void main(String[] args) {
    testNormalCase();
    testExactLengthCase();
    testLargeNCase();
    testEmptyStringCase();
    testZeroNCase();
    testUnicodeCase();
    testNegativeNThrows();
    System.out.println("All MaskString tests passed successfully.");
  }

  private static void testNormalCase() {
    String result = MaskString.maskString("1234567890", 4);
    if (!result.equals("******7890")) {
      throw new AssertionError("Expected ******7890 but got: " + result);
    }
  }

  private static void testExactLengthCase() {
    String result = MaskString.maskString("1234", 4);
    if (!result.equals("1234")) {
      throw new AssertionError("Expected 1234 but got: " + result);
    }
  }

  private static void testLargeNCase() {
    String result = MaskString.maskString("1234", 10);
    if (!result.equals("1234")) {
      throw new AssertionError("Expected 1234 but got: " + result);
    }
  }

  private static void testEmptyStringCase() {
    String result = MaskString.maskString("", 0);
    if (!result.equals("")) {
      throw new AssertionError("Expected empty string but got: " + result);
    }
  }

  private static void testZeroNCase() {
    String result = MaskString.maskString("hello", 0);
    if (!result.equals("*****")) {
      throw new AssertionError("Expected ***** but got: " + result);
    }
  }

  private static void testUnicodeCase() {
    String result = MaskString.maskString("\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02", 1);
    if (!result.equals("\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02")) {
      int codePointCount = result.codePointCount(0, result.length());
      if (codePointCount != 3 || !result.endsWith("\uD83D\uDE02")) {
        throw new AssertionError("Expected unicode preservation but got: " + result);
      }
    }
  }

  private static void testNegativeNThrows() {
    boolean threw = false;
    try {
      MaskString.maskString("12345", -1);
    } catch (IllegalArgumentException e) {
      threw = true;
    }
    if (!threw) {
      throw new AssertionError("Expected IllegalArgumentException for negative N");
    }
  }
}
