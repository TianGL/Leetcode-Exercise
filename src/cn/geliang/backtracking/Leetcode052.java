package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode052 {
    // 20190708
    private int res;
    boolean[] col; // 判断某一列是否可以放置
    boolean[] dia1; // 判断自左上到右下的对角线 i-j值相等
    boolean[] dia2; // 判断自右上到左下的对角线 i+j值相等

    public int totalNQueens(int n) {
        res = 0;
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        Arrays.fill(col, false);
        Arrays.fill(dia1, false);
        Arrays.fill(dia2, false);
        getQueens(n, 0, new ArrayList<Integer>());
        return res;
    }

    private void getQueens(int n, int idx, ArrayList<Integer> pos) {
        if (idx == n) {
            res++;
            return;
        }

        for (int j = 0; j < n; ++j) {
            // 遍历（idx, j） 的每个位置
            if (!col[j] && !dia1[idx + j] && !dia2[idx - j + n - 1]) {
                // 递归回溯
                col[j] = true;
                dia1[idx + j] = true;
                dia2[idx - j + n - 1] = true;
                pos.add(j);
                getQueens(n, idx + 1, pos);
                col[j] = false;
                dia1[idx + j] = false;
                dia2[idx - j + n - 1] = false;
                pos.remove(idx);
            }
        }
    }

}
