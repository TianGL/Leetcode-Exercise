package cn.geliang.array;

public class Leetcode075 {
	// 20190420
	// 利用三路快排思想
    public void sortColors(int[] nums) {
        int zeroIdx = -1;
        int twoIdx = nums.length;
        for(int oneIdx = 0; oneIdx < twoIdx;) {
        	if(nums[oneIdx] == 1) {
        		oneIdx++;
        	} else if (nums[oneIdx] == 0) {
        		zeroIdx++;
        		nums[zeroIdx] = 0;
        		if(zeroIdx != oneIdx) {
        			nums[oneIdx] = 1;
        		}
        		
        		oneIdx++;
        	} else {
        		twoIdx--;
        		int temp = nums[twoIdx];
        		nums[twoIdx] = 2;
        		nums[oneIdx] = temp;
        	}
        }
    }

}
