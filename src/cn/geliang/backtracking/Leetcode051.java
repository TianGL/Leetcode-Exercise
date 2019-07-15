package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode051 {

    // 20190708
    private List<List<String>> res;
    boolean[] col; // 判断某一列是否可以放置
    boolean[] dia1; // 判断自左上到右下的对角线 i-j值相等
    boolean[] dia2; // 判断自右上到左下的对角线 i+j值相等

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
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
            res.add(generateBoard(n, pos));
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

    // 生成需要的字符串数组
    private List<String> generateBoard(int n, ArrayList<Integer> pos) {
        List<String> board = new ArrayList<>();
        char[] pointChars = new char[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(pointChars, '.');
            pointChars[pos.get(i)] = 'Q';
            board.add(new String(pointChars));
        }
        return board;
    }

    public static void main(String[] args) {
        Leetcode051 sol = new Leetcode051();
        System.out.println(sol.solveNQueens(4));
    }
}
