package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode093 {
    // 20190615

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        getIpAddress(s, 0, 1, new StringBuilder());
        return res;
    }

    public void getIpAddress(String s, int startIdx, int partNum, StringBuilder stringBuilder) {
        if (startIdx >= s.length()) {
            if (partNum == 5) {
                // 代表IP地址4部分已经解析完
                res.add(stringBuilder.toString());
            }
            return;
        }
        if (partNum >= 2) {
            stringBuilder.append(".");
        }
        for (int i = 0; i < 3 && (startIdx + i < s.length()); ++i) {
            String digitsStr = s.substring(startIdx, startIdx + i + 1);
            if (digitsStr.length() > 1 && digitsStr.charAt(0) == '0') {
                break;
            }
            if (Integer.valueOf(digitsStr) > 255) {
                // 不能不能大于255
                break;
            }
            int insertStart = stringBuilder.length();
            int insertEnd = insertStart + digitsStr.length();
            stringBuilder.append(digitsStr);
            getIpAddress(s, startIdx + i + 1, partNum + 1, stringBuilder);
            stringBuilder.delete(insertStart, insertEnd);
        }
        if (partNum >= 2) {
            // 清除点
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


    public static void main(String[] args) {
        String input = "010010";
        Leetcode093 sol = new Leetcode093();
        System.out.println(sol.restoreIpAddresses(input));
    }

}
