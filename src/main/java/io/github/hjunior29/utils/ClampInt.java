package io.github.hjunior29.utils;

/** Integer clamping with inclusive bounds. */
public final class ClampInt {
 private ClampInt() {}

 /** Clamp value to the bounds, rejecting lower bounds greater than upper bounds. */
 public static int clampInt(int value, int lower, int upper) {
  if (lower > upper) { throw new IllegalArgumentException("Lower bound must not exceed upper bound"); }
  return Math.max(lower, Math.min(value, upper));
 }
}
