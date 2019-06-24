package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode046 {
    // 20190624
    List<List<Integer>> res;
    boolean[] isSelected;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        isSelected = new boolean[nums.length];
        Arrays.fill(isSelected, false);
        getPermute(nums, new ArrayList<Integer>());
        return res;
    }

    private void getPermute(int[] nums, List<Integer> onePermute) {
        if (nums.length == onePermute.size()) {
            List<Integer> oneRes = new ArrayList<>(onePermute);
            res.add(oneRes);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isSelected[i] == false) {
                isSelected[i] = true;
                onePermute.add(nums[i]);
                getPermute(nums, onePermute);
                onePermute.remove(onePermute.size()-1);
                isSelected[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Leetcode046 sol = new Leetcode046();
        System.out.println(sol.permute(nums));
    }

}
