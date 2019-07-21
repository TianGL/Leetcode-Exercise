package cn.geliang.dp;

public class Leetcode474 {
    // 20190721
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (String s : strs) {
            int[] count = clcZeroOne(s);
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 不在s上使用
                    if ( i-count[0] >=0 && j-count[1] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] clcZeroOne(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode474 sol = new Leetcode474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(sol.findMaxForm(strs, m, n));
    }
}
