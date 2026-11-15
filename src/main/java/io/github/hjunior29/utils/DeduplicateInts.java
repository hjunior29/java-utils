package io.github.hjunior29.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DeduplicateInts {
  private DeduplicateInts() {}

  public static int[] deduplicateInts(int[] input) {
    if (input == null) {
      throw new IllegalArgumentException("Input array cannot be null");
    }
    Set<Integer> seen = new HashSet<>();
    List<Integer> resultList = new ArrayList<>();
    for (int value : input) {
      if (seen.add(value)) {
        resultList.add(value);
      }
    }
    int[] result = new int[resultList.size()];
    for (int i = 0; i < resultList.size(); i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }
}
