package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Leetcode350 {
	// 20190426
    public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> record = new HashMap<Integer, Integer>();
    	for(int num1: nums1) {
    		record.put(num1, record.getOrDefault(num1, 0) + 1);
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int num2: nums2) {
    		if(record.containsKey(num2) && record.get(num2) != 0) {
    			list.add(num2);
    			record.put(num2, record.get(num2) - 1);
    		}
    	}
    	int[] res = new int[list.size()];
    	for(int i = 0; i < list.size(); ++i) {
    		res[i] = list.get(i);
    	}
        return res;
    }
}
