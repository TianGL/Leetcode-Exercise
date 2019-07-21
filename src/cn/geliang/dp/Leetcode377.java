package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode377 {

    // 20190721
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = nums[0]; i <= target; ++i) {
            for (int j = 0; j < n && i >= nums[j]; ++j) {

                dp[i] += dp[i - nums[j]];

            }
        }
        return dp[target];
    }

    // 20190721
    public int combinationSum4_a(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int m = target / nums[0];
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][target + 1]; // [i][j]由i个元素组成和为j
        for (int i = 0; i < n && nums[i] <= target; ++i) {
            dp[1][nums[i]] = 1;
        }
        for (int i = 2; i <= m; i++) {
            // i为组合的元素数目
            for (int j = 0; j < n; j++) {
                for (int t = nums[0]; t + nums[j] <= target; t++) {
                    dp[i][t + nums[j]] += dp[i - 1][t];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += dp[i][target];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode377 sol = new Leetcode377();
        int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int target = 10;
        System.out.println(sol.combinationSum4(nums, target));
    }
}
