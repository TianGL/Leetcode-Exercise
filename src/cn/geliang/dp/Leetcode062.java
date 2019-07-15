package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode062 {
    // 20190710
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 2; i <=m; i++) {
            for (int j=1; j <=n; ++j) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}
