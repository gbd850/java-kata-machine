package dev.peter;

public class BinarySearch {
    public static int binarySearch(int[] array, int val) {
        int left = 0;
        int right = array.length;
        int mid;
        while (left < right) {
            mid = (int) Math.floor(left + (double) (right - left) / 2);
            if (array[mid] == val) {
                return mid;
            }
            if (array[mid] < val) {
                left = mid + 1;
            }
            if (array[mid] > val) {
                right = mid;
            }
        }
        return -1;
    }
}
