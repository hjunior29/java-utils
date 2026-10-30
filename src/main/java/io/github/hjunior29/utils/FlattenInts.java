package io.github.hjunior29.utils;

import java.util.ArrayList;
import java.util.List;

public final class FlattenInts {
  private FlattenInts() {}

  public static int[] flattenInts(int[][] sequences) {
    if (sequences == null) {
      throw new IllegalArgumentException("Sequences array cannot be null");
    }
    List<Integer> flattened = new ArrayList<>();
    for (int i = 0; i < sequences.length; i++) {
      int[] seq = sequences[i];
      if (seq == null) {
        throw new IllegalArgumentException("Sub-sequence cannot be null");
      }
      for (int j = 0; j < seq.length; j++) {
        flattened.add(seq[j]);
      }
    }
    int[] result = new int[flattened.size()];
    for (int i = 0; i < flattened.size(); i++) {
      result[i] = flattened.get(i);
    }
    return result;
  }
}
