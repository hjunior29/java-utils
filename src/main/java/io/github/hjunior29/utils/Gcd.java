package io.github.hjunior29.utils;

public final class Gcd {
  private Gcd() {}

  public static int gcd(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Arguments must be nonnegative integers.");
    }
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
