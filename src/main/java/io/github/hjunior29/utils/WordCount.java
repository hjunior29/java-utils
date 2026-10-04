package io.github.hjunior29.utils;

import java.util.regex.Pattern;

/** Whitespace-separated word counting. */
public final class WordCount {
 private WordCount() {}

 /** Count nonempty groups separated by Unicode whitespace. */
 public static int wordCount(String value) {
  String[] words = Pattern.compile("\\s+", Pattern.UNICODE_CHARACTER_CLASS).split(value);
  int count = 0;
  for (String word : words) { if (!word.isEmpty()) { count++; } }
  return count;
 }
}
