package dev.peter;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        boolean isAltered = true;
        for (int i = 0; i < array.length; i++) {
            if (!isAltered) break;
            isAltered = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isAltered = true;
                }
            }
        }
        return array;
    }
}
