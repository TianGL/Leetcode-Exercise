package cn.geliang.dp;

import java.util.Arrays;
import java.util.Iterator;

public class Leetcode322 {
    // 20190720
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if ( n <= 0) {
            return amount == 0 ? 0 : -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        // 根据coins[0] 进行初始化
        int count = 1;
        int ans = coins[0];
        while (ans <= amount) {
            dp[ans] = count;
            count++;
            ans += coins[0];
        }

        for (int i = 1; i < n; i++) {
            count = 1;
            ans = coins[i];
            while (ans <= amount) {
                for (int c = amount; c - ans >= 0; c--) {
                    if (dp[c-ans] != -1) {
                        if (dp[c] == -1) {
                            dp[c] = dp[c-ans] + count;
                        } else {
                            dp[c] = Math.min(dp[c], dp[c-ans] + count);
                        }
                    }
                }
                count++;
                ans += coins[i];
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 27;
        Leetcode322 sol = new Leetcode322();
        System.out.println(sol.coinChange(coins, amount));
    }
}
