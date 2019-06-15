package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode017 {
    // 20190615
    String[] letterMap = {
        " ",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combination(digits, 0, new StringBuilder());
        return res;
    }

    private void combination(String digits, int idx, StringBuilder stringBuilder) {
        if (idx == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        String letters = letterMap[digits.charAt(idx) - '0'];
        for (int i=0; i < letters.length(); ++i) {
            stringBuilder.append(letters.charAt(i));
            combination(digits, idx+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
