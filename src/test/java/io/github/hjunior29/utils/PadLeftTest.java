package io.github.hjunior29.utils;

public class PadLeftTest {
  public static void main(String[] args) {
    testNormalPadding();
    testNoPaddingNeeded();
    testEmptyInput();
    testInvalidTargetLength();
    testUnicodePadding();
    System.out.println("All PadLeft tests passed successfully.");
  }

  private static void testNormalPadding() {
    String result = PadLeft.padLeft("abc", 5, '0');
    if (!result.equals("00abc")) {
      throw new AssertionError("Expected '00abc', got '" + result + "'");
    }
  }

  private static void testNoPaddingNeeded() {
    String result = PadLeft.padLeft("abcdef", 5, '0');
    if (!result.equals("abcdef")) {
      throw new AssertionError("Expected 'abcdef', got '" + result + "'");
    }
  }

  private static void testEmptyInput() {
    String result = PadLeft.padLeft("", 3, 'x');
    if (!result.equals("xxx")) {
      throw new AssertionError("Expected 'xxx', got '" + result + "'");
    }
  }

  private static void testInvalidTargetLength() {
    boolean thrown = false;
    try {
      PadLeft.padLeft("abc", -1, '0');
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for negative target length.");
    }
  }

  private static void testUnicodePadding() {
    String result = PadLeft.padLeft("\uD83D\ude00", 3, '_');
    if (!result.equals("__\uD83D\ude00")) {
      throw new AssertionError("Expected '__\uD83D\uDE00', got '" + result + "'");
    }
  }
}
