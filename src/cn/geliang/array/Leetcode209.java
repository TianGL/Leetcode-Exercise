package cn.geliang.array;

public class Leetcode209 {
	
	// 20190423
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	
    	int res = nums.length + 1;
    	int lo = 0, hi = -1;
    	int sum = 0;
    	while(lo < nums.length) {
    		if(hi + 1 < nums.length && sum < s) {
    			hi++;
    			sum += nums[hi];
    		} else {
    			sum -= nums[lo];
    			lo++;
    		}
    		if(sum >= s) {
    			res = Math.min(res, hi-lo+1);
    		}
    	}
    	if(res == nums.length + 1) {
    		return 0;
    	}
    	return res;
    	
    }

}
