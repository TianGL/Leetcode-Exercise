package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode078 {
    // 20190624
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            generateSubsets(nums, 0, size, new ArrayList<>());
        }
        return res;
    }

    private void generateSubsets(int[] nums, int start, int size, List<Integer> subset) {
        if (subset.size() == size) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < nums.length - size + subset.size() + 1; i++) {
            subset.add(nums[i]);
            generateSubsets(nums, i + 1, size, subset);
            subset.remove(subset.size()-1);
        }
    }
}
