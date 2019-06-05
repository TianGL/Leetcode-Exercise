package cn.geliang.array;

import java.util.Arrays;

public class Leetcode003 {
	
	// 20190424
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        int lo = 0, hi = -1;
        int[] freq = new int[256];
        while(lo < arr.length) {
        	if(hi + 1 < arr.length && freq[arr[hi+1]] == 0) {
        		hi++;
        		freq[arr[hi]]++;
        	} else {
        		freq[arr[lo]]--;
        		lo++;
        	}
        	res = Math.max(res, hi-lo+1);
        }
        return res;
        
    }

}
