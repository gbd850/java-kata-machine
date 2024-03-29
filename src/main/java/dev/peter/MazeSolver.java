package dev.peter;

import java.awt.*;
import java.util.Stack;

public class MazeSolver {

    private static final int[][] dir = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static boolean walk(String[] maze, Character wall, Point curr, Point end, boolean[][] seen, Stack<Point> path) {

        // 1. off the map
        if (curr.x < 0 || curr.x >= maze[0].length() ||
                curr.y < 0 || curr.y >= maze.length) {
            return false;
        }
        // 2. on the wall
        if (maze[curr.y].charAt(curr.x) == wall) {
            return false;
        }
        // 3. the end
        if (curr.x == end.x && curr.y == end.y) {
            path.push(end);
            return true;
        }
        // 4. point seen before
        if (seen[curr.y][curr.x]) {
            return false;
        }

        // 3 recurse
        //  pre
        seen[curr.y][curr.x] = true;
        path.push(curr);

        //  recurse
        for (int i = 0; i < dir.length; i++) {
            if (walk(maze, wall, new Point(curr.x + dir[i][0], curr.y + dir[i][1]), end, seen, path)) {
                return true;
            }
        }

        //  post
        path.pop();

        return false;
    }

    public static Point[] solve(String[] maze, Character wall, Point start, Point end) {
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        Stack<Point> path = new Stack<>();

        for (int i = 0; i < seen.length; i++) {
            for (int j = 0; j < seen[0].length; j++) {
                seen[i][j] = false;
            }
        }
        walk(maze, wall, start, end, seen, path);

        return path.toArray(new Point[0]);
    }
}
