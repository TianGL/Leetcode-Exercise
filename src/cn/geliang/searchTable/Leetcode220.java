package cn.geliang.searchTable;

import java.util.TreeSet;

public class Leetcode220 {
    // 20190511
	// ÀûÓÃtreeset
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0; i < nums.length; ++i) {
        	long lo = (long)nums[i] - t, hi = (long)nums[i] + t;
        	if(record.ceiling(lo) != null && record.ceiling(lo) <= hi) {
        		return true;
        	}
        	record.add((long) nums[i]);
        	if(record.size() == k + 1) {
        		record.remove((long)nums[i-k]);
        	}
        }
        return false;
        
    }
}
