package io.github.hjunior29.utils;

public class RemovePrefixTest {
  public static void main(String[] args) {
    testNormal();
    testEmpty();
    testBoundary();
    testInvalid();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormal() {
    String result = RemovePrefix.removePrefix("unhappy", "un");
    if (!result.equals("happy")) {
      throw new AssertionError("Expected happy, got " + result);
    }
  }

  private static void testEmpty() {
    String result = RemovePrefix.removePrefix("", "");
    if (!result.equals("")) {
      throw new AssertionError("Expected empty string, got " + result);
    }
  }

  private static void testBoundary() {
    String result = RemovePrefix.removePrefix("prefix", "notprefix");
    if (!result.equals("prefix")) {
      throw new AssertionError("Expected prefix, got " + result);
    }
  }

  private static void testInvalid() {
    boolean caught = false;
    try {
      RemovePrefix.removePrefix(null, "test");
    } catch (IllegalArgumentException e) {
      caught = true;
    }
    if (!caught) {
      throw new AssertionError("Expected IllegalArgumentException for null input");
    }
  }
}
