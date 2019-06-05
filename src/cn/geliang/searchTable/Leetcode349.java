package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leetcode349 {
	// 20190426
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num:nums1) {
        	set1.add(num);
        }
        for(int num:nums2) {
        	if(set1.contains(num) && !set2.contains(num)) {
        		set2.add(num);
        	}
        }
        Iterator<Integer> itr = set2.iterator();
        int[] res = new int[set2.size()];
        for(int i = 0; i < res.length; ++i) {
        	res[i] = itr.next();
        }
        return res;
    }
}
