package dev.peter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoCrystalBallsProblemTest {

    @Test
    void givenArray_shouldReturnValidIndex() {
        boolean[] array = {false, false, false, true, true, true, true, true};
        assertEquals(3, TwoCrystalBallsProblem.twoCrystalBallsProblem(array));
    }

    @Test
    void givenArray_shouldReturnInvalidIndex() {
        boolean[] array = {false, false, false, false, false, false};
        assertEquals(-1, TwoCrystalBallsProblem.twoCrystalBallsProblem(array));
    }
}