package io.github.hjunior29.utils;

public final class BinarySearchInts {
  private BinarySearchInts() {}

  public static int binarySearchInts(int[] array, int target) {
    if (array == null) {
      throw new IllegalArgumentException("Array cannot be null");
    }
    int low = 0;
    int high = array.length - 1;
    int result = -1;
    while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (array[mid] == target) {
        result = mid;
        high = mid - 1;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return result;
  }
}
