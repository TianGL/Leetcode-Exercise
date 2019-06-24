package cn.geliang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode401 {
    // 20190624
    List<String> res;
    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        boolean[] binaryLED = new boolean[10]; // 前四位代表小时，后6位代表分钟，都是由低到高
        Arrays.fill(binaryLED, false);
        getTime(binaryLED, 0, 0, num);
        return res;
    }

    private void getTime(boolean[] binaryLED, int start, int curNum, int num) {
        if (curNum == num) {
            String timeStr = getStrTime(binaryLED);
            if (timeStr.length() > 0) {
                res.add(getStrTime(binaryLED));
            }
            return;
        }

        for (int i = start; i < binaryLED.length - (num - curNum) + 1; i++) {
            binaryLED[i] = true;
            getTime(binaryLED, i + 1, curNum+1, num);
            binaryLED[i] = false;
        }
    }

    private String getStrTime(boolean[] binaryLED) {
        int hour = 0;
        int digit = 1;
        for (int i = 0; i < 4; i++) {
            if (binaryLED[i] == true) {
                hour += digit;
            }
            digit = digit << 1;
        }

        if (hour > 11) {
            return "";
        }

        int minute = 0;
        digit = 1;
        for (int i = 4; i < 10; i++) {
            if (binaryLED[i] == true) {
                minute += digit;
            }
            digit = digit << 1;
        }

        if (minute > 59) {
            return "";
        }

        if (minute < 10) {
            return hour + ":" + "0" + minute;
        } else {
            return hour + ":" + minute;
        }
    }

    public static void main(String[] args) {
//        String[] s1 = {"3:00","5:00","9:00","1:01","1:02","1:04","1:08","1:16","1:32","6:00","10:00","2:01","2:02","2:04","2:08","2:16","2:32","12:00","4:01","4:02","4:04","4:08","4:16","4:32","8:01","8:02","8:04","8:08","8:16","8:32","0:03","0:05","0:09","0:17","0:33","0:06","0:10","0:18","0:34","0:12","0:20","0:36","0:24","0:40","0:48"};
//        String[] validStr = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
//        Arrays.sort(s1);
//        System.out.println(Arrays.asList(s1));
//        System.out.println(Arrays.asList(validStr));
        Leetcode401 sol = new Leetcode401();
        System.out.println(sol.readBinaryWatch(2));
    }




}
