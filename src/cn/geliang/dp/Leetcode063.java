package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode063 {
    // 20190710
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // 初始化第一行
        dp[0] = 0;
        if (obstacleGrid[0][0] != 1) {
            dp[1] = 1;
        }
        for (int j = 2; j <= n; j++) {
            if (obstacleGrid[0][j - 1] != 1) {
                dp[j] = dp[j - 1];
            }
        }

        // 遍历
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] != 1) {
                    dp[j] = dp[j] + dp[j - 1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode063 sol = new Leetcode063();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
    }
}
