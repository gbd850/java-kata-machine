package dev.peter;

public class QuickSort {

    private static void qs(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        final int pivotIdx = partition(array, lo, hi);

        qs(array, lo, pivotIdx - 1);
        qs(array, pivotIdx + 1, hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        final int pivot = array[hi];

        int idx = lo - 1;

        for (int i = lo; i < hi; i++) {
            if(array[i] <= pivot) {
                idx++;
                int tmp = array[i];
                array[i] = array[idx];
                array[idx] = tmp;
            }
        }
        idx++;
        array[hi] = array[idx];
        array[idx] = pivot;

        return idx;
    }

    public static void quickSort(int[] array) {
        qs(array, 0, array.length - 1);
    }
}
