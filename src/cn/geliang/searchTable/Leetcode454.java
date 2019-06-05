package cn.geliang.searchTable;

import java.util.HashMap;

public class Leetcode454 {
	// 20190507
	// O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	HashMap<Integer, Integer> sumCD = new HashMap<Integer, Integer>();
        for(int i = 0; i < C.length; ++i) {
        	for(int j = 0; j < D.length; ++j) {
        		sumCD.put(C[i]+D[j], sumCD.getOrDefault(C[i]+D[j], 0)+1);
        	}
        }
        int res = 0;
        for(int k = 0; k < A.length; ++k) {
        	for(int l = 0; l < B.length; ++l) {
        		res += sumCD.getOrDefault(0-A[k]-B[l], 0);
        	}
        }
        return res;
    }
}
