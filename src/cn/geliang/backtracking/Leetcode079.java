package cn.geliang.backtracking;

import java.util.Arrays;

public class Leetcode079 {
    // 20190625
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] isVisit;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        isVisit = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(isVisit[i], false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, 0, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int idx, String word, int x, int y) {
        if (idx == word.length() - 1) {
            if (board[x][y] == word.charAt(idx)) {
                return true;
            }
            return false;
        }

        if (board[x][y] == word.charAt(idx)) {
            isVisit[x][y] = true;
            for (int i = 0; i < 4; ++i) {
                int nextX = x + move[i][0];
                int nextY = y + move[i][1];
                if (inArea(nextX, nextY) && !isVisit[nextX][nextY]) {
                    if (search(board, idx + 1, word, nextX, nextY)) {
                        return true;
                    }
                }
            }
            isVisit[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}
