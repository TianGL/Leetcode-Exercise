package cn.geliang.array;

public class Leetcode080 {
	
	// 20190418
    public int removeDuplicates(int[] nums) {
    	int idx = 0;
    	int twiceFlag = 1;
    	for (int i = idx + 1; i < nums.length; i++) {
    		// 重复为1且相等
			if(twiceFlag == 1 && nums[i] == nums[idx]) {
				idx++;
				if(i != idx) {
					nums[idx] = nums[i];
				}
				twiceFlag = 2;
			} else if (nums[i] != nums[idx]) {
				idx++;
				if(idx != i) {
					nums[idx] = nums[i];
				}
				twiceFlag = 1;
			}
		}
    	return idx+1;
      
    }

}
