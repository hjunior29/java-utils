package io.github.hjunior29.utils;

public class FibonacciTest {

  public static void main(String[] args) {
    testNormalCases();
    testBoundaryCases();
    testInvalidCases();
    System.out.println("All tests passed successfully.");
  }

  private static void testNormalCases() {
    if (Fibonacci.fibonacci(2) != 1) {
      throw new AssertionError("F(2) should be 1");
    }
    if (Fibonacci.fibonacci(3) != 2) {
      throw new AssertionError("F(3) should be 2");
    }
    if (Fibonacci.fibonacci(6) != 8) {
      throw new AssertionError("F(6) should be 8");
    }
    if (Fibonacci.fibonacci(10) != 55) {
      throw new AssertionError("F(10) should be 55");
    }
  }

  private static void testBoundaryCases() {
    if (Fibonacci.fibonacci(0) != 0) {
      throw new AssertionError("F(0) should be 0");
    }
    if (Fibonacci.fibonacci(1) != 1) {
      throw new AssertionError("F(1) should be 1");
    }
    if (Fibonacci.fibonacci(30) != 832040) {
      throw new AssertionError("F(30) should be 832040");
    }
  }

  private static void testInvalidCases() {
    boolean negativeCaught = false;
    try {
      Fibonacci.fibonacci(-1);
    } catch (IllegalArgumentException e) {
      negativeCaught = true;
    }
    if (!negativeCaught) {
      throw new AssertionError("Expected IllegalArgumentException for negative input");
    }

    boolean overflowCaught = false;
    try {
      Fibonacci.fibonacci(31);
    } catch (IllegalArgumentException e) {
      overflowCaught = true;
    }
    if (!overflowCaught) {
      throw new AssertionError("Expected IllegalArgumentException for input greater than 30");
    }
  }
}
