package io.github.hjunior29.utils;

public final class ChunkInts {
  private ChunkInts() {}

  public static int[][] chunkInts(int[] sequence, int size) {
    if (sequence == null) {
      throw new IllegalArgumentException("Sequence cannot be null");
    }
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be positive");
    }
    if (sequence.length == 0) {
      return new int[0][0];
    }
    int totalChunks = (sequence.length + size - 1) / size;
    int[][] result = new int[totalChunks][];
    for (int i = 0; i < totalChunks; i++) {
      int start = i * size;
      int end = Math.min(sequence.length, start + size);
      int[] chunk = new int[end - start];
      System.arraycopy(sequence, start, chunk, 0, chunk.length);
      result[i] = chunk;
    }
    return result;
  }
}
