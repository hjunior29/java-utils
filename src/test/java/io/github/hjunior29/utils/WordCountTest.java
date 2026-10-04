package io.github.hjunior29.utils;

/** Regression tests for whitespace-separated words. */
public final class WordCountTest {
  public static void main(String[] args) {
    String[] inputs = {"", " \t\n", "hello", " hello  world\nagain ", "one\u2003two"};
    int[] expected = {0, 0, 1, 3, 2};
    for (int i = 0; i < inputs.length; i++) {
      if (WordCount.wordCount(inputs[i]) != expected[i]) {
        throw new AssertionError("Unexpected word count");
      }
    }
  }
}
