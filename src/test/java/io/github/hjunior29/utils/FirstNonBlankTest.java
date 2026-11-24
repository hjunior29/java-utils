package io.github.hjunior29.utils;

import java.util.Optional;

public final class FirstNonBlankTest {
  private FirstNonBlankTest() {}

  public static void main(String[] args) {
    testNullArray();
    testEmptyArray();
    testAllBlank();
    testFirstIsNonBlank();
    testLaterIsNonBlank();
    testMultipleNonBlank();
    System.out.println("All tests passed successfully.");
  }

  private static void testNullArray() {
    Optional<String> result = FirstNonBlank.firstNonBlank((CharSequence[]) null);
    if (result.isPresent()) {
      throw new AssertionError("Expected empty for null array");
    }
  }

  private static void testEmptyArray() {
    Optional<String> result = FirstNonBlank.firstNonBlank();
    if (result.isPresent()) {
      throw new AssertionError("Expected empty for empty array");
    }
  }

  private static void testAllBlank() {
    Optional<String> result = FirstNonBlank.firstNonBlank(null, "", "   ", "\t\n");
    if (result.isPresent()) {
      throw new AssertionError("Expected empty when all elements are blank or null");
    }
  }

  private static void testFirstIsNonBlank() {
    Optional<String> result = FirstNonBlank.firstNonBlank("hello", "world");
    if (!result.isPresent() || !result.get().equals("hello")) {
      throw new AssertionError("Expected 'hello'");
    }
  }

  private static void testLaterIsNonBlank() {
    Optional<String> result = FirstNonBlank.firstNonBlank(null, "", "   ", "target");
    if (!result.isPresent() || !result.get().equals("target")) {
      throw new AssertionError("Expected 'target'");
    }
  }

  private static void testMultipleNonBlank() {
    Optional<String> result = FirstNonBlank.firstNonBlank("   ", "first", "second");
    if (!result.isPresent() || !result.get().equals("first")) {
      throw new AssertionError("Expected 'first'");
    }
  }
}
