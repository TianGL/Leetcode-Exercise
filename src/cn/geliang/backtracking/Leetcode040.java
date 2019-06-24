package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode040 {
    // 20190624
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        generateCombinationSum(k, n, 1, 0, new ArrayList<>());
        return res;
    }

    private void generateCombinationSum(int k, int target, int start, int curSum, List<Integer> c) {
        if (curSum > target) {
            return;
        }
        if (c.size() == k ) {
            if (curSum == target) {
                List<Integer> temp = new ArrayList<>(c);
                res.add(temp);
            }
            return;
        }

        for (int i = start; i <=9; ++i) {
            c.add(i);
            generateCombinationSum(k, target, i+1, curSum + i, c);
            c.remove(c.size()-1);
        }
    }

}
