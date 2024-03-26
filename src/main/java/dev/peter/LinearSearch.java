package dev.peter;

public class LinearSearch {
    public static <T> boolean linearSearch(T[] array, T val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
