package cn.geliang.array;

public class Leetcode283 {
	// 20190418
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // �����������
        for(int i = 0; i < n; i++) {
        	if(nums[i] != 0) {
        		if(j != i) {
        			nums[j] = nums[i];
        			nums[i] = 0; // nums[j]��Ȼ��0
        		}
        		j++;
        	}
        }
    }
}
