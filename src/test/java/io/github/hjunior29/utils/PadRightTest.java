package io.github.hjunior29.utils;

public class PadRightTest {
  public static void main(String[] args) {
    testNormalPadding();
    testAlreadyLonger();
    testExactLength();
    testEmptyString();
    testInvalidNull();
    testUnicodeAndShortTargets();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalPadding() {
    String result = PadRight.padRight("abc", 5, 'x');
    if (!"abcxx".equals(result)) {
      throw new AssertionError("Expected abcxx, got " + result);
    }
  }

  private static void testAlreadyLonger() {
    String result = PadRight.padRight("abcdef", 4, 'x');
    if (!"abcdef".equals(result)) {
      throw new AssertionError("Expected abcdef, got " + result);
    }
  }

  private static void testExactLength() {
    String result = PadRight.padRight("abc", 3, 'x');
    if (!"abc".equals(result)) {
      throw new AssertionError("Expected abc, got " + result);
    }
  }

  private static void testEmptyString() {
    String result = PadRight.padRight("", 3, '0');
    if (!"000".equals(result)) {
      throw new AssertionError("Expected 000, got " + result);
    }
  }

  private static void testUnicodeAndShortTargets() {
    if (!"😀xx".equals(PadRight.padRight("😀", 3, 'x'))) {
      throw new AssertionError("Length must count Unicode code points");
    }
    if (!"abc".equals(PadRight.padRight("abc", 0, 'x'))
        || !"abc".equals(PadRight.padRight("abc", -1, 'x'))) {
      throw new AssertionError("Short targets must not truncate");
    }
  }

  private static void testInvalidNull() {
    boolean thrown = false;
    try {
      PadRight.padRight(null, 5, 'x');
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for null input");
    }
  }
}
