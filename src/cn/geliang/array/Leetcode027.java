package cn.geliang.array;

public class Leetcode027 {
	// 20190418
    public int removeElement(int[] nums, int val) {
        int idx = 0; // ĞÂË÷Òı
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				if(idx != i && nums[idx] != nums[i]) {
					nums[idx] = nums[i];
				}
				idx++;
			}
		}
        return idx;
    }

}
