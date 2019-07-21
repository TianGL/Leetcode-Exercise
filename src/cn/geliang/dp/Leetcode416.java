package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode416 {
    // 20190720
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            // 奇数不可行
            return false;
        }

        int c = sum >> 1;
        boolean[] dp = new boolean[c + 1];
        Arrays.fill(dp, false);
        if (nums[0] <= c) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j > 0; j--) {
                dp[j] = dp[j] || (j - nums[i] >= 0 && dp[j-nums[i]] );
                if (dp[c] == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
