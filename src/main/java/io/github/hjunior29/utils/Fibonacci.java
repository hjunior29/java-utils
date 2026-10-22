package io.github.hjunior29.utils;

public final class Fibonacci {

  private Fibonacci() {
    throw new UnsupportedOperationException("Utility class");
  }

  public static int fibonacci(int n) {
    if (n < 0 || n > 30) {
      throw new IllegalArgumentException("Input must be between 0 and 30 inclusive.");
    }
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    int a = 0;
    int b = 1;
    int result = 0;

    for (int i = 2; i <= n; i++) {
      result = a + b;
      a = b;
      b = result;
    }

    return result;
  }
}
