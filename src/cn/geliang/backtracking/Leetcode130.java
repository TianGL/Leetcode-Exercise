package cn.geliang.backtracking;

import java.util.Arrays;

public class Leetcode130 {
    // 20190625
    // 从4个边遍历
    // 20190624
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
//    boolean[][] isVisit;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (n == 0) {
            return;
        }

        for (int j = 0; j < n; ++j) {
            // 第一行
            if ( board[0][j] == 'O') {
                dfs(board, 0, j);
            }
        }
        for (int j = 0; j < n; ++j) {
            // 最后一行
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            // 第一列
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        for (int i = 0; i < m; ++i) {
            // 最后一列
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }


        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y]='#';
        for (int i = 0; i < 4; ++i) {
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if (inArea(nextX, nextY) && board[nextX][nextY] == 'O') {
                dfs(board, nextX, nextY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}
