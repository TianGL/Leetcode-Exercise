package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode198 {
    // 20190716
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i+1] = Math.max(dp[i], nums[i]);
            for (int j = i - 1; j >= 1; j--) {
                dp[i+1] = Math.max(dp[i+1], dp[j] + nums[i]);
            }
//            System.out.println(i+1 + " " +dp[i+1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Leetcode198 sol = new Leetcode198();
        System.out.println(sol.rob(nums));
    }
}
