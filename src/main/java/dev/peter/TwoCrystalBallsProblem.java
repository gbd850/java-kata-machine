package dev.peter;

public class TwoCrystalBallsProblem {
    public static int twoCrystalBallsProblem(boolean[] array) {
        int currIndex = 0;
        int lastIndex = 0;
        int length = array.length;
        int jump = (int) Math.floor(Math.sqrt(length));
        while (currIndex < length) {
            if (array[currIndex]) break;

            lastIndex = currIndex;
            currIndex += jump;
        }
        int index = -1;
        for (int i = lastIndex; i < currIndex; i++) {
            if (array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
