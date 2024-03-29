package dev.peter;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    @Test
    void givenMaze_shouldSolveCase1() {
        String[] maze = new String[] {
                "######E#",
                "#      #",
                "#S######"
        };
        Point start = new Point(1, 2);
        Point end = new Point(6, 0);

        Point[] expectedPath = new Point[] {
                new Point(1, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(4, 1),
                new Point(5, 1),
                new Point(6, 1),
                new Point(6, 0)
        };
        Point[] path = MazeSolver.solve(maze, '#', start, end);

        assertArrayEquals(expectedPath, path);
    }

    @Test
    void givenMaze_shouldSolveCase2() {
        String[] maze = new String[] {
                "########",
                "#S     #",
                "#E######"
        };
        Point start = new Point(1, 1);
        Point end = new Point(1, 2);

        Point[] expectedPath = new Point[] {
                start, end
        };
        Point[] path = MazeSolver.solve(maze, '#', start, end);

        assertArrayEquals(expectedPath, path);
    }
}