package cn.geliang.backtracking;

import java.util.*;

public class Leetcode047 {
    // 20190624
    List<List<Integer>> res;
    boolean[] isSelected;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
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
            if (i != 0 && nums[i] == nums[i-1] && !isSelected[i-1]) {
                // 如果与前一个元素相等且isSelected[i-1]==false，则证明前一个刚好被
                continue;
            }
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
        int[] nums = {1,1,2};
        Leetcode047 sol = new Leetcode047();
        System.out.println(sol.permuteUnique(nums));
    }
}
