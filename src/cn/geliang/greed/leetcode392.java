package cn.geliang.greed;

public class leetcode392 {
    // 20190726
    public boolean isSubsequence(String s, String t) {
        int sidx = 0, tidx = 0;
        while (sidx < s.length() && tidx < t.length()) {
            if (s.charAt(sidx) == t.charAt(tidx)) {
                sidx++;
            }
            tidx++;
        }
        return sidx == s.length();
    }
}
