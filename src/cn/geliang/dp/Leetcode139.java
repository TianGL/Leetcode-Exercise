package cn.geliang.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode139 {
    // 20190720
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        boolean[] dp = new boolean[n+1]; // s中[0,i]是否可以被dict拼接成功
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    int start = i - word.length();
                    dp[i] = dp[i] || ( dp[i-word.length()] && word.equals(s.substring(start, start + word.length())) );
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        Leetcode139 sol = new Leetcode139();
        System.out.println(sol.wordBreak(s, wordDict));
    }
}
