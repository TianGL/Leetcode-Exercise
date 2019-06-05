package cn.geliang.searchTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode290 {
	
	public static void main(String[] args) {
		Leetcode290 sol = new Leetcode290();
		System.out.println(sol.wordPattern("abba", "dog cat cat dog"));
		System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
		System.out.println(sol.wordPattern("abba", "dog dog dog dog"));
	}
	
	// 20190426
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) {
        	return false;
        }
        
        Map<Character, String> relation = new HashMap<Character, String>();
        Set<String> record = new HashSet<String>();
        for(int i = 0; i < strs.length; ++i) {
        	if(!relation.containsKey(pattern.charAt(i))) {
        		if(record.contains(strs[i])) { // 如果字符串已经被记录
        			return false;
        		}
        		// 记录映射及已被映射的字符串
        		relation.put(pattern.charAt(i), strs[i]);
        		record.add(strs[i]);
        	} else {
        		if(!relation.get(pattern.charAt(i)).equals(strs[i])) {
        			return false;
        		}
        	}
        }
        return true;
    }
}
