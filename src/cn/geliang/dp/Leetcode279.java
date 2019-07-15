package cn.geliang.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode279 {
    // 20190710
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Queue<Integer> dpIdxQueue = new ArrayDeque<>();
        dpIdxQueue.add(0); // dp[0] = 0;
        while (dpIdxQueue.size() != 0) {
            int num = dpIdxQueue.poll();
            for (int i = 1; ; i++) {
                int nextNum = num + i*i;
                if (nextNum > n) { // 超出范围
                    break;
                }
                if (dp[nextNum] == 0) {
                    // nextNum未被访问
                    dp[nextNum] = dp[num] + 1; // num 走一步既可以到达nextNum
                    if (nextNum == n) {
                        return dp[n];
                    }
                    dpIdxQueue.add(nextNum);
                }
            }
        }
        return dp[n];
    }
}
