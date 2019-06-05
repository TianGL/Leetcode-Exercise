package cn.geliang.array;

public class Leetcode076 {
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String p = "ABC";
		Leetcode076 sol = new Leetcode076();
		System.out.println(sol.minWindow(s, p));
	}
	
	// 20190423
    public String minWindow(String s, String t) {
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();
    	int[] res = new int[2];
    	res[0] = Integer.MAX_VALUE;
    	int[] sfreq = new int[256];
    	int[] tfreq = new int[256];
    	
    	for(char c: tArr) {
    		tfreq[c]++;
    	}
    	
    	int lo = 0, hi = -1;
    	int count = 0;
    	while(lo + tArr.length - 1 < sArr.length) {
    		if(hi + 1 < sArr.length && count < t.length()) {
    			hi++;
    			// 取到t中某个字符时count+1
    			if(sfreq[sArr[hi]] < tfreq[sArr[hi]] ) {
    				count++;
    			}
    			// 若sArr[hi]是t中字符
    			if(tfreq[sArr[hi]] != 0) {
    				sfreq[sArr[hi]]++;
    			}
    		} else {
    			// 若sArr[hi]是t中字符
    			if(sfreq[sArr[lo]] >0) {
    				sfreq[sArr[lo]]--;
    				// 当t中某个字符不在窗内时
    				if( sfreq[sArr[lo]] < tfreq[sArr[lo]]) {
    					count--;
    				}	
    			}
    			lo++;
    		}
//    		System.out.println(count + ", " + lo + ", " + hi);
    		if(count == t.length() && hi-lo+1 < res[0]) {
//    			System.out.println(lo+"," +hi);
    			res[0] = hi-lo+1;
    			res[1] = lo;
    		}
    	}
    	if(res[0] == Integer.MAX_VALUE) {
    		return "";
    	}
    	return s.substring(res[1], res[1]+res[0]);
        
    }
}
