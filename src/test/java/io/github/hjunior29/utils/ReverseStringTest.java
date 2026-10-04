package io.github.hjunior29.utils;

/** Regression tests for Unicode string reversal. */
public final class ReverseStringTest {
 public static void main(String[] args) {
  String[][] cases = {{"", ""}, {"a", "a"}, {"hello", "olleh"}, {"a😀é", "é😀a"}};
  for (String[] example : cases) {
   if (!ReverseString.reverseString(example[0]).equals(example[1])) { throw new AssertionError("Unexpected reversed string"); }
  }
 }
}
