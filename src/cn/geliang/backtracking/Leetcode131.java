package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode131 {
    // 20190615

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        getPalindrome(s, 0, new ArrayList<String>());
        return res;
    }

    private void getPalindrome(String s, int startIdx, List<String> palindromeStrs) {
        if (startIdx == s.length()) {
            List<String> strs = new ArrayList<>(palindromeStrs);
            res.add(strs);
        }
        for (int i = 0; startIdx + i < s.length(); ++i) {
            String str = s.substring(startIdx, startIdx + i + 1);
            if (isPalindrome(str)) {
                palindromeStrs.add(str);
                getPalindrome(s, startIdx + i + 1, palindromeStrs);
                palindromeStrs.remove(palindromeStrs.size() - 1);
            }
        }
    }

    // 判断字符串是否回文
    private boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
