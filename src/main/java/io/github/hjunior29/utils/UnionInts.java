package io.github.hjunior29.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UnionInts {

  private UnionInts() {}

  public static int[] unionInts(int[] first, int[] second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Input arrays cannot be null.");
    }

    List<Integer> resultList = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    for (int value : first) {
      if (seen.add(value)) {
        resultList.add(value);
      }
    }

    for (int value : second) {
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
