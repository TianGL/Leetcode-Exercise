package cn.geliang.array;

import java.util.Random;

public class Leetcode215 {
	
	private static Random rd = new Random();
	// 20190420
    public int findKthLargest(int[] nums, int k) {
    	swap(nums, 0, rd.nextInt(nums.length));
    	int lo = 0, hi = nums.length-1;
    	k = k - 1;
    	while(lo < hi) {
    		int pivotIdx = partition(nums, lo, hi);
    		if(pivotIdx < k) {
    			lo = pivotIdx + 1;
    		} else if (pivotIdx > k) {
    			hi = pivotIdx - 1;
    		} else {
    			break;
    		}
    	}
    	return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi) {
    	int pivot = nums[lo];
    	while(lo < hi) {
    		
    		while(lo < hi && nums[hi] < pivot) {
    			hi--;
    		}
    		if(lo < hi) {
    			nums[lo++] = nums[hi];
    		}
    		while(lo < hi && nums[lo] >= pivot) {
    			lo++;
    		}
    		if(lo < hi) {
    			nums[hi--] = nums[lo];
    		}
    	}
    	nums[lo] = pivot;
    	return lo;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

}
