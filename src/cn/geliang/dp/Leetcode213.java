package cn.geliang.dp;

import java.util.Arrays;

public class Leetcode213 {
    // 20190716
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 偷1...n-1或2...n;
        int[] get = new int[n+1]; // 最后一个偷get[i]
        int[] leave = new int[n+1]; // 最后一个不偷leave[i]
        // 偷1...n-1
        get[1] = nums[0];
        for (int i = 1; i < n-1; i++) {
            get[i+1] = leave[i] + nums[i];
            leave[i+1] = Math.max(get[i], leave[i]);
        }
        int res = Math.max(get[n-1], leave[n-1]);
        res = Math.max(res, get[1]); // 只有一个元素的情况

        // 偷2...n
        get[1] = 0;
        for (int i = 1; i < n; i++) {
            get[i+1] = leave[i] + nums[i];
            leave[i+1] = Math.max(get[i], leave[i]);
        }
        res = Math.max(res, get[n]);
        res = Math.max(res, leave[n]);
        return res;
    }

    // 20190716
//    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, 0);
//        // 根据是否偷第一个分两种情况
//
//        // 1）偷第一个
//        dp[1] = nums[0];
//        for (int i = 1; i < n - 1; ++i) {
//            dp[i + 1] = Math.max(dp[i], nums[i]);
//            for (int j = i - 1; j >= 1; j--) {
//                dp[i + 1] = Math.max(dp[i + 1], dp[j] + nums[i]);
//            }
//        }
//        int res = res = Math.max(dp[1], dp[n-1]); // 考虑到只有一个元素的情况
//
//        // 2)不偷第一个
//        dp[1] = 0;
//        for (int i = 1; i < n; ++i) {
//            dp[i + 1] = Math.max(dp[i], nums[i]);
//            for (int j = i - 1; j >= 1; j--) {
//                dp[i + 1] = Math.max(dp[i + 1], dp[j] + nums[i]);
//            }
//        }
//        return Math.max(res, dp[n]);
//    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        Leetcode213 sol = new Leetcode213();
        System.out.println(sol.rob(nums));
    }
}
