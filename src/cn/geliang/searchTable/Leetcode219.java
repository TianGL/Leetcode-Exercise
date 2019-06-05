package cn.geliang.searchTable;

import java.util.HashSet;

public class Leetcode219 {
	// 20190511
	// 查找表+滑动窗口
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashSet<Integer> record = new HashSet<Integer>();
    	for(int i = 0; i <= k && i < nums.length; ++i) {
    		if(record.contains(nums[i])) {
    			return true;
    		}
    		record.add(nums[i]);
    	}
    	int lo = 0, hi = k+1;
    	while(hi < nums.length) {
    		record.remove(nums[lo]);
    		if(record.contains(nums[hi])) {
    			return true;
    		}
    		record.add(nums[hi]);
    		hi++;
    		lo++;
    	}
        return false;
    }

}
