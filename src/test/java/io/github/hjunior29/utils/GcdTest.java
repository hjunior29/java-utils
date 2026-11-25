package io.github.hjunior29.utils;

public class GcdTest {
  public static void main(String[] args) {
    testGcd();
    System.out.println("All Gcd tests passed successfully.");
  }

  private static void testGcd() {
    if (Gcd.gcd(0, 0) != 0) {
      throw new AssertionError("gcd(0,0) should be 0");
    }
    if (Gcd.gcd(5, 0) != 5) {
      throw new AssertionError("gcd(5,0) should be 5");
    }
    if (Gcd.gcd(0, 7) != 7) {
      throw new AssertionError("gcd(0,7) should be 7");
    }
    if (Gcd.gcd(48, 18) != 6) {
      throw new AssertionError("gcd(48,18) should be 6");
    }
    if (Gcd.gcd(17, 13) != 1) {
      throw new AssertionError("gcd(17,13) should be 1");
    }
    boolean exceptionThrown = false;
    try {
      Gcd.gcd(-1, 5);
    } catch (IllegalArgumentException e) {
      exceptionThrown = true;
    }
    if (!exceptionThrown) {
      throw new AssertionError("Expected IllegalArgumentException for negative input");
    }
  }
}
