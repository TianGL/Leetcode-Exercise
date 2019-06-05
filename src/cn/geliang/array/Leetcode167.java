package cn.geliang.array;

public class Leetcode167 {
	// 20190420
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
        	int sum = numbers[left] + numbers[right];
        	if(sum < target) {
        		left++;
        	} else if (sum > target) {
        		right--;
        	} else {
        		break;
        	}
        }
        return new int[] {left+1, right+1};
    }
}
