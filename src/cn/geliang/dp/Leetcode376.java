package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode376 {
    // 20190718
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] positive = new int[n]; // 当前点为positive
        int[] negative = new int[n]; // 当前点为negative
        Arrays.fill(positive, 1);
        Arrays.fill(negative,1);
        int res = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = i -1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    positive[i] = Math.max(positive[i], negative[j] + 1);
                    res = Math.max(positive[i], res);
                    j = j - negative[j];
                    continue;
                }
                if (nums[i] < nums[j]) {
                    negative[i] = Math.max(negative[i], positive[j] + 1);
                    res = Math.max(negative[i], res);
                    j = j - positive[j];
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        Leetcode376 sol = new Leetcode376();
        System.out.println(sol.wiggleMaxLength(nums));
    }
}
