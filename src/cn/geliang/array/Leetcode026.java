package cn.geliang.array;

public class Leetcode026 {
	// 20190418
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = idx+1; i < nums.length; i++) {
			if(nums[i] != nums[idx]) {
				idx++;
				nums[idx] = nums[i];
			}
		}
        return idx+1;
    }

}
