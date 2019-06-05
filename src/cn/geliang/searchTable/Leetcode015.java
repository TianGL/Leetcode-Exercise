package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode015 {
	// 20190506
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for(int i = 0; i < nums.length - 2; ++i) {
    		// ���ȱ�����Сֵ�������Ѿ��������Ľ��ȥ��
    		if(i != 0 && nums[i] == nums[i-1]) {
    			continue;
    		}
    		int mid = i + 1, hi = nums.length-1; // �м�ֵ�����ֵ
    		while(mid < hi) {
    			// ���б�Ҫ����mid����ȥ��
    			while(mid != i + 1 && mid < hi && nums[mid] == nums[mid-1]) {
    				mid++;
    			}
    			// ���б�Ҫ����hi����ȥ��
    			while(hi != nums.length - 1 && mid < hi && nums[hi] == nums[hi+1]) {
    				hi--;
    			}
    			if( mid < hi) {
    				int curSum = nums[i] + nums[mid] + nums[hi];
    				if(curSum == 0) {
    					res.add(Arrays.asList(nums[i], nums[mid], nums[hi]));
    					mid++;
    					hi--;
    				} else if (curSum < 0) {
    					mid++;
    				} else {
    					hi--;
    				}
    			}
    		}
    	}
    	return res;

    }
}
