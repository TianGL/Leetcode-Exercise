package cn.geliang.backtracking;

import java.util.Arrays;

public class Leetcode200 {
    // 20190624
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    boolean[][] isVisit;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        isVisit = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(isVisit[i], false);
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !isVisit[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        isVisit[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if (inArea(nextX, nextY) && !isVisit[nextX][nextY] && grid[nextX][nextY] == '1') {
                dfs(grid, nextX, nextY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
