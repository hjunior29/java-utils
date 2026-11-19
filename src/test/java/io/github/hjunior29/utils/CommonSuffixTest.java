package io.github.hjunior29.utils;

public class CommonSuffixTest {
  public static void main(String[] args) {
    testExactMatch();
    testPartialMatch();
    testNoMatch();
    testEmptyInputs();
    testUnicodeHandling();
    testNullHandling();
    System.out.println("All tests passed successfully.");
  }

  private static void testExactMatch() {
    String result = CommonSuffix.commonSuffix("hello", "hello");
    if (!result.equals("hello")) {
      throw new AssertionError("Expected 'hello', got '" + result + "'");
    }
  }

  private static void testPartialMatch() {
    String result = CommonSuffix.commonSuffix("programming", "gaming");
    if (!result.equals("ming")) {
      throw new AssertionError("Expected 'ming', got '" + result + "'");
    }
  }

  private static void testNoMatch() {
    String result = CommonSuffix.commonSuffix("abc", "xyz");
    if (!result.equals("")) {
      throw new AssertionError("Expected empty string, got '" + result + "'");
    }
  }

  private static void testEmptyInputs() {
    String result1 = CommonSuffix.commonSuffix("", "abc");
    if (!result1.equals("")) {
      throw new AssertionError("Expected empty string, got '" + result1 + "'");
    }
    String result2 = CommonSuffix.commonSuffix("", "");
    if (!result2.equals("")) {
      throw new AssertionError("Expected empty string, got '" + result2 + "'");
    }
  }

  private static void testUnicodeHandling() {
    String result = CommonSuffix.commonSuffix("café", "laté");
    if (!result.equals("é")) {
      throw new AssertionError("Expected 'é', got '" + result + "'");
    }
  }

  private static void testNullHandling() {
    boolean caught = false;
    try {
      CommonSuffix.commonSuffix(null, "test");
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null first argument");
    }
  }
}
