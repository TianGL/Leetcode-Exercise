package cn.geliang.backtracking;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode417 {
    // 20190625
    List<List<Integer>> res;
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] isVisit; // 标记是否访问过
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) {
            return res;
        }
        n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        isVisit = new boolean[m][n];

        boolean[][] wayToPac = new boolean[m][n];
        ; // 标记是否可以到达太平洋
        boolean[][] wayToAtl = new boolean[m][n];
        ; // 标记是否可以到达大西洋

        for (int i = 0; i < m; ++i) {
            Arrays.fill(isVisit[i], false);
            Arrays.fill(wayToPac[i], false);
            Arrays.fill(wayToAtl[i], false);
        }

        for (int i = 0; i < m; ++i) {
            search(matrix, i, 0, wayToPac, Integer.MIN_VALUE);
            search(matrix, i, n - 1, wayToAtl, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; ++j) {
            search(matrix, 0, j, wayToPac, Integer.MIN_VALUE);
            search(matrix, m - 1, j, wayToAtl, Integer.MIN_VALUE);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wayToPac[i][j] && wayToAtl[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void search(int[][] matrix, int x, int y, boolean[][] isWayToSea, int perHeight) {
        if (isWayToSea[x][y] == true) {
            return;
        }
        if (matrix[x][y] >= perHeight) {
            isWayToSea[x][y] = true;
        } else {
            return;
        }
        isVisit[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if (inArea(nextX, nextY) && !isVisit[nextX][nextY]) {
                search(matrix, nextX, nextY, isWayToSea, matrix[x][y]);
            }
        }
        isVisit[x][y] = false;
    }

    private boolean inArea(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] matrix = {{1,1}, {1,1}, {1,1}};
        Leetcode417 sol = new Leetcode417();
        System.out.println(sol.pacificAtlantic(matrix));
    }
}
