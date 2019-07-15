package cn.geliang.backtracking;

import java.util.Arrays;

public class Leetcode037 {
    // 20190708
    boolean[][] row; // 行判断
    boolean[][] col; // 列标记
    boolean[][] cell; // 每个cell标记 i/3*3 + j/3
    public void solveSudoku(char[][] board) {
        // 初始化
        row = new boolean[9][9];
        col = new boolean[9][9];
        cell = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            Arrays.fill(row[i], false);
            Arrays.fill(col[i], false);
            Arrays.fill(cell[i], false);
        }

        // 初始标记赋值
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = Character.digit(board[i][j], 10) - 1;
                    row[i][num] = true;
                    col[j][num] = true;
                    cell[i/3*3 + j/3][num] = true;
                }
            }
        }

        getBoard(board, 0, 0);


    }

    private boolean getBoard(char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }

        int nextX = x;
        int nextY = y + 1;
        if (nextY == 9) {
            nextX = x + 1;
            nextY = 0;
        }

        if (board[x][y] != '.') {
            // 不是需要填空的位置，继续遍历下一位置
            return getBoard(board, nextX, nextY);
        }

        for (int num = 1; num <= 9; num++) {
            if (!col[y][num-1] && !row[x][num-1] && !cell[x/3*3 + y/3][num-1]) {
                col[y][num-1] = true;
                row[x][num-1] = true;
                cell[x/3*3 + y/3][num-1] = true;
                board[x][y] = Character.forDigit(num, 10);
                boolean curRes = getBoard(board, nextX, nextY);
                if (curRes) {
                    return true;
                }
                col[y][num-1] = false;
                row[x][num-1] = false;
                cell[x/3*3 + y/3][num-1] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }
}
