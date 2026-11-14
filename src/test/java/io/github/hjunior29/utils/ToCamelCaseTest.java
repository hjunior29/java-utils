package io.github.hjunior29.utils;

public class ToCamelCaseTest {

  public static void main(String[] args) {
    testNormalCases();
    testEmptyAndBlankCases();
    testBoundaryCases();
    testInvalidCases();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCases() {
    String result1 = ToCamelCase.toCamelCase("hello_world");
    if (!"helloWorld".equals(result1)) {
      throw new AssertionError("Expected helloWorld, got " + result1);
    }

    String result2 = ToCamelCase.toCamelCase("foo_bar_baz");
    if (!"fooBarBaz".equals(result2)) {
      throw new AssertionError("Expected fooBarBaz, got " + result2);
    }

    String result3 = ToCamelCase.toCamelCase("ALREADY_LOWER_OR_UPPER");
    if (!"alreadyLowerOrUpper".equals(result3)) {
      throw new AssertionError("Expected alreadyLowerOrUpper, got " + result3);
    }
  }

  private static void testEmptyAndBlankCases() {
    String result1 = ToCamelCase.toCamelCase("");
    if (!"".equals(result1)) {
      throw new AssertionError("Expected empty string, got " + result1);
    }

    String result2 = ToCamelCase.toCamelCase("__foo__bar__");
    if (!"fooBar".equals(result2)) {
      throw new AssertionError("Expected fooBar, got " + result2);
    }
  }

  private static void testBoundaryCases() {
    String result1 = ToCamelCase.toCamelCase("word");
    if (!"word".equals(result1)) {
      throw new AssertionError("Expected word, got " + result1);
    }

    String result2 = ToCamelCase.toCamelCase("a_b_c");
    if (!"aBC".equals(result2)) {
      throw new AssertionError("Expected aBC, got " + result2);
    }
  }

  private static void testInvalidCases() {
    boolean thrown = false;
    try {
      ToCamelCase.toCamelCase(null);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }

    if (!thrown) {
      throw new AssertionError("Expected IllegalArgumentException for null input");
    }
  }
}
