package cn.geliang.dp;

public class Leetcode064 {
    // 20190708
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 0; j < n; j ++) {
            dp[j+1] = dp[j] + grid[0][j];
        }
        dp[0] = Integer.MAX_VALUE; //设为最大值，避免用dp[0]来更新
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[j+1] = Math.min(dp[j+1], dp[j]) + grid[i][j];
            }
        }
        return dp[n];
    }
}
