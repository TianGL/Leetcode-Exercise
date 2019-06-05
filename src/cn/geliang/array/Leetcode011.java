package cn.geliang.array;

public class Leetcode011 {
	// 20190421
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
        	int curContainer = (right - left)*(Math.min(height[left], height[right])); 
        	if(curContainer > res) {
        		res = curContainer;
        	}
        	if(height[left] < height[right]) {
        		left++;
        	} else if(height[left] == height[right]) {
        		left++;
        		right--;
        	} else {
        		right--;
        	}
        }
    	return res;
    }
}
