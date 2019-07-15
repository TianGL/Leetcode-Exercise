package cn.geliang.dp;

public class Leetcode091 {
    // 20190710
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1]; // dp[i] 到第i个字符可能的解码数目
        dp[0] = 1;
        // 判断第一个数字是否合法
        dp[1] = parseStr(s,0,1);
        if (dp[1] == 0) {
            return 0;
        }
        for (int i = 2; i <=n; i++) {
            // 更新dp
            int num1 = parseStr(s,i-1,i);
            int num2 = parseStr(s,i-2,i);
            dp[i] = num1*dp[i-1] + num2*dp[i-2];

        }
        return dp[n];
    }

    // 判断子字符串是否合法，合法返回1，否则0（不能解码）；
    private int parseStr(String s, int start, int end) {
        if (s.charAt(start) == '0') {
            return 0;
        }
        int num = Integer.parseInt(s.substring(start, end));
        if (num >=1 && num <=26) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(Integer.parseInt(s.substring(0,2)));
    }
}
