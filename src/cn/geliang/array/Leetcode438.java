package cn.geliang.array;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
	public static void main(String[] args) {
		String s = "acdcaeccde";
		String p = "c";
		Leetcode438 sol = new Leetcode438();
		System.out.println(sol.findAnagrams(s, p));
	}
	
	//20190423
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<>();
    	
    	if(s.length() < p.length()) {
    		return res;
    	}
    	
    	char[] sArr = s.toCharArray();
    	char[] pArr = p.toCharArray();
    	int[] sFreq = new int[256];
    	int[] pFreq = new int[256];
    	for(char c : pArr) {
    		pFreq[c]++;
    	}
    	
    	int lo = 0, hi = -1;
    	int count = 0;
    	while(lo + pArr.length - 1 < sArr.length) {
    		if(hi + 1 < sArr.length && count < pArr.length &&
    				( pFreq[sArr[hi+1]] == 0 || sFreq[sArr[hi+1]] < pFreq[sArr[hi+1]]) ) {
    			hi++;
    			if(sFreq[sArr[hi]] < pFreq[sArr[hi]]) {
    				sFreq[sArr[hi]]++;
    				count++;
    			}
    		} else {
    			if(pFreq[sArr[lo]] != 0) {
    				sFreq[sArr[lo]]--;
    				count--;
    			}
    			lo++;
    		}
    		
    		if(count == pArr.length && hi-lo+1 == count) {
    			res.add(lo);
    		}
    		
    	}
    	return res;
    	
    }
}
