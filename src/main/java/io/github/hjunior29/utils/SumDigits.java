package io.github.hjunior29.utils;

public final class SumDigits {
  private SumDigits() {}

  public static int sumDigits(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be nonnegative");
    }
    int sum = 0;
    int temp = n;
    while (temp > 0) {
      sum += temp % 10;
      temp /= 10;
    }
    return sum;
  }
}
