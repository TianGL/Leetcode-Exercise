package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode077 {
    // 20190624
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <=0 || k <= 0 || k > n) {
            return res;
        }
        generateCombinations(n, 1, k, new ArrayList<Integer>());
        return res;
    }

    private void generateCombinations(int n, int start, int k, List<Integer> c) {
        if (c.size() == k) {
            List<Integer> temp = new ArrayList<>(c);
            res.add(temp);
            return;
        }

        for (int i = start; i <= n - (k-c.size())+1; i++) {
            c.add(i);
            generateCombinations(n, i+1, k, c);
            c.remove(c.size()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode077 sol = new Leetcode077();
        System.out.println(sol.combine(4,2));
    }
}
