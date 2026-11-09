package io.github.hjunior29.utils;

public class CommonPrefixTest {
  public static void main(String[] args) {
    testNormalCase();
    testEmptyCase();
    testIdenticalCase();
    testNoCommonPrefix();
    testNullArguments();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCase() {
    String result = CommonPrefix.commonPrefix("interspecies", "interstellar");
    if (!"inters".equals(result)) {
      throw new AssertionError("Expected 'inters', got '" + result + "'");
    }
  }

  private static void testEmptyCase() {
    String result = CommonPrefix.commonPrefix("", "abc");
    if (!"".equals(result)) {
      throw new AssertionError("Expected empty string, got '" + result + "'");
    }
  }

  private static void testIdenticalCase() {
    String result = CommonPrefix.commonPrefix("hello", "hello");
    if (!"hello".equals(result)) {
      throw new AssertionError("Expected 'hello', got '" + result + "'");
    }
  }

  private static void testNoCommonPrefix() {
    String result = CommonPrefix.commonPrefix("dog", "cat");
    if (!"".equals(result)) {
      throw new AssertionError("Expected empty string, got '" + result + "'");
    }
  }

  private static void testNullArguments() {
    boolean thrown = false;
    try {
      CommonPrefix.commonPrefix(null, "test");
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for null first argument");
    }
  }
}
