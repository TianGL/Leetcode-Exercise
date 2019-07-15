package cn.geliang.dp;

import java.util.List;

public class Leetcode120 {

    // 20190708
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; ++j) {
            dp[j] = triangle.get(n-1).get(j);
        }
        for (int level = n-2; level >=0; --level) {
            for (int j = 0; j <= level; ++j) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(level).get(j);
            }
        }
        return dp[0];
    }
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] dp = new int[n][n];
//        dp[0][0] = triangle.get(0).get(0);
//        for (int i = 1; i < n; i++) {
//            // 逐行更新
//            for (int j = 0; j <=i; j ++) {
//                if (j == 0) {
//                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
//                    continue;
//                }
//                if (j == i) {
//                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);;
//                    continue;
//                }
//                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);;
//            }
//        }
//
//        // 寻找最小值
//        int res = dp[n-1][0];
//        for (int j = 1; j < n; j++) {
//            if (dp[n-1][j] < res) {
//                res = dp[n-1][j];
//            }
//        }
//        return res;
//    }
}
