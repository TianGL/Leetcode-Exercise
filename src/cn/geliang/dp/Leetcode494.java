package cn.geliang.dp;

public class Leetcode494 {
    // 20190720
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int total = sum + sum + 1;
        int[][] dp = new int[n][total]; // 利用前i个元素组成j的次数
        dp[0][nums[0] + sum] = dp[0][nums[0] + sum] + 1;
        dp[0][-nums[0] + sum] = dp[0][-nums[0] + sum] + 1;
        for (int i = 1; i < n; i++) {
            // 加减两种可能
            int[] target = new int[2];
            target[0] = nums[i];
            target[1] = -nums[i];
            for (int t : target) {
                for (int j = 0; j < total; j++) {
                    if (dp[i-1][j] != 0) {
                        dp[i][j+t] += dp[i-1][j];
                    }
                }
            }
        }
        if ( S >= total || S + sum >= total) { // 有越界测试？？
            return 0;
        }
        return dp[n-1][S+sum];
    }

    public static void main(String[] args) {
        Leetcode494 sol = new Leetcode494();
        int[] nums = {1, 0};
        int S = 1;
        System.out.println(sol.findTargetSumWays(nums, S));
    }
}
