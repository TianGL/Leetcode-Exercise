package cn.geliang.dp;

/*
 * create by Geliang Tian
 * 2019-07-16
 */
public class Leetcode309 {
    // 20190716

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] buy = new int[n+1]; // 最后一次操作是买
        int[] sell = new int[n+1]; // 最后一次操作是卖
        buy[1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            buy[i+1] = Math.max(sell[i-1] - prices[i], buy[i]);
            sell[i+1] = Math.max(buy[i] + prices[i], sell[i]);
        }
        return sell[n];
    }

    public static void main(String[] args) {
        Leetcode309 sol = new Leetcode309();
        int[] prices = {1,2,3,0,2};
        System.out.println(sol.maxProfit(prices));
    }
}
