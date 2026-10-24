package io.github.hjunior29.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DifferenceInts {

  private DifferenceInts() {}

  public static List<Integer> differenceInts(List<Integer> first, List<Integer> second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Inputs must not be null");
    }

    Set<Integer> secondSet = new HashSet<>(second);
    Set<Integer> seen = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    for (Integer value : first) {
      if (value == null) {
        throw new IllegalArgumentException("Elements must not be null");
      }
      if (!secondSet.contains(value) && seen.add(value)) {
        result.add(value);
      }
    }

    return result;
  }
}
