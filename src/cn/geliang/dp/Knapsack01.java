package cn.geliang.dp;

import java.util.Arrays;

public class Knapsack01 {

    // 从右向左更新，只需要1行
    public int knapsack01_c(int[] weight, int [] value, int capacity) {
        int n = weight.length;
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // 初始化
        int[] dp = new int[capacity+1]; // dp[i][j] 第0...i个背包，容量为j的最优解
        for (int j = 1; j <= capacity; j++) {
            if (j >= weight[0]) {
                dp[j] = value[0];
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = capacity; j >= 1; j--) {
                dp[j] = Math.max(dp[j-1], (j - weight[i] >= 0) ? (dp[j - weight[i]] + value[i]) : 0);
            }
        }
        return dp[capacity];
    }

    // 从左到右遍历，只需要2行
    public int knapsack01_b(int[] weight, int [] value, int capacity) {
        int n = weight.length;
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // 初始化
        int[][] dp = new int[2][capacity+1]; // dp[i][j] 第0...i个背包，容量为j的最优解
        for (int j = 1; j <= capacity; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= capacity; j++) {

                dp[i%2][j] = Math.max(dp[(i-1)%2][j], (j - weight[i] >= 0) ? (dp[(i-1)%2][j - weight[i]] + value[i]) : 0);
//                System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        return dp[(n-1)%2][capacity];
    }

    public int knapsack01_a(int[] weight, int [] value, int capacity) {
        int n = weight.length;
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // 初始化
        int[][] dp = new int[n][capacity+1]; // dp[i][j] 第0...i个背包，容量为j的最优解
        for (int j = 1; j <= capacity; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= capacity; j++) {

                dp[i][j] = Math.max(dp[i-1][j], (j - weight[i] >= 0) ? (dp[i-1][j - weight[i]] + value[i]) : 0);
//                System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
        int capacity = 5;
        Knapsack01 sol = new Knapsack01();
        System.out.println(sol.knapsack01_a(weight, value, capacity));
        System.out.println(sol.knapsack01_b(weight, value, capacity));
        System.out.println(sol.knapsack01_c(weight, value, capacity));
    }
}
