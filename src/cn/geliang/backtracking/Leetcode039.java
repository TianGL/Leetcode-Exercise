package cn.geliang.backtracking;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class Leetcode039 {
    // 20190624
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        generateCombinationSum(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void generateCombinationSum(int[] candidates, int start, int curSum, int target, List<Integer> c) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            List<Integer> temp = new ArrayList<>(c);
            res.add(temp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            c.add(candidates[i]);
            generateCombinationSum(candidates, i, curSum + candidates[i], target, c);
            c.remove(c.size()-1);
        }
    }
}
