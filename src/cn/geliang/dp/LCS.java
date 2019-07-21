package cn.geliang.dp;

import cn.geliang.stackAndQueue.NestedInteger;

public class LCS {
    // 20190720
    // Longest Common Sequence

    // 获取LCS长度
    public int getLCS(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1]; // dp[i][j] a中[0,i]和b中[0,j]的最长公共子序列
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }

    // 获取LSC字符串
    public String getStrLCS(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1]; // dp[i][j] a中[0,i]和b中[0,j]的最长公共子序列
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        int i = m, j = n;
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i-1) == b.charAt(j-1)) {
                stringBuilder.insert(0,a.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] >= dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "AAACCGTGAGTTATTCGTTCTAGAA";
        String b = "CACCCCTAAGGTACCTTTGGTTC";
        LCS sol = new LCS();
        System.out.println(sol.getLCS(a, b));
        System.out.println(sol.getStrLCS(a, b));
    }
}
