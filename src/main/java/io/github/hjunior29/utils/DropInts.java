package io.github.hjunior29.utils;

import java.util.ArrayList;
import java.util.List;

public final class DropInts {
  private DropInts() {}

  public static List<Integer> dropInts(List<Object> input, int n) {
    if (n < 0) {
      throw new IllegalArgumentException("N cannot be negative");
    }
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    List<Integer> result = new ArrayList<>();
    int intCount = 0;
    for (Object item : input) {
      if (item instanceof Integer) {
        intCount++;
        if (intCount > n) {
          result.add((Integer) item);
        }
      }
    }
    return result;
  }
}
