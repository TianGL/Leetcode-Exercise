package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode343 {
    // 20190711
    public int integerBreak(int n) {
        int[] dp = new int[n+1]; // dp[i], 和为i所能代表的最大乘积
        Arrays.fill(dp, -1);
        dp[1] = 1; // 底层条件
        for (int i = 2; i <= n; i++) {
            // 依次获取dp[i]
            for (int j = 1; j <= i-1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
                // 对于Math.max(j*(i-j), j*dp[j])， 当前分解包含j 和 i-j 或dp[i-j]（i-j至少分解成两个元素）
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode343 sol = new Leetcode343();
        System.out.println(sol.integerBreak(10));
    }

}
