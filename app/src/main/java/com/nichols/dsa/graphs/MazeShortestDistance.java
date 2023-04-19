package com.nichols.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeShortestDistance {
    private static final int[][] DIRS = {{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};

    public int solve(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] row: distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int[] dir: DIRS) {
                int x = position[0];
                int y = position[1];
                int count = 0;

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                x -= dir[0];
                y -= dir[1];
                count--;
                if (distance[position[0]][position[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[position[0]][position[1]] + count;
                    queue.add(new int[] {x, y});
                }
            }
        }

        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
