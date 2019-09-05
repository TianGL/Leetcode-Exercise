package cn.geliang.greed;

import java.util.Arrays;

public class Leetcode455 {
    // 20190726
    public int findContentChildren(int[] g, int[] s) {
        int gidx = g.length-1, sidx = s.length-1;
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (sidx >= 0 && gidx >= 0) {
            if (s[sidx] >= g[gidx]) {
                res++;
                gidx--;
                sidx--;
            } else {
                gidx--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Leetcode455 sol = new Leetcode455();
        System.out.println(sol.findContentChildren(g, s));
    }

}
