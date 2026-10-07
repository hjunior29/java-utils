package io.github.hjunior29.utils;

public class NormalizeWhitespaceTest {
  public static void main(String[] args) {
    testNormalCases();
    testEmptyAndWhitespaceOnly();
    testBoundaryCases();
    testInvalidCases();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCases() {
    String result1 = NormalizeWhitespace.normalizeWhitespace("hello   world");
    if (!result1.equals("hello world")) {
      throw new AssertionError("Failed normal case 1, got: " + result1);
    }

    String result2 = NormalizeWhitespace.normalizeWhitespace("   foo\tbar\n   baz   ");
    if (!result2.equals("foo bar baz")) {
      throw new AssertionError("Failed normal case 2, got: " + result2);
    }
  }

  private static void testEmptyAndWhitespaceOnly() {
    String result1 = NormalizeWhitespace.normalizeWhitespace("");
    if (!result1.equals("")) {
      throw new AssertionError("Failed empty case, got: " + result1);
    }

    String result2 = NormalizeWhitespace.normalizeWhitespace("   \t\n   ");
    if (!result2.equals("")) {
      throw new AssertionError("Failed whitespace-only case, got: " + result2);
    }
  }

  private static void testBoundaryCases() {
    String result1 = NormalizeWhitespace.normalizeWhitespace("a");
    if (!result1.equals("a")) {
      throw new AssertionError("Failed single char case, got: " + result1);
    }

    String result2 = NormalizeWhitespace.normalizeWhitespace(" a ");
    if (!result2.equals("a")) {
      throw new AssertionError("Failed single padded char case, got: " + result2);
    }
  }

  private static void testInvalidCases() {
    boolean caught = false;
    try {
      NormalizeWhitespace.normalizeWhitespace(null);
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null input");
    }
  }
}
