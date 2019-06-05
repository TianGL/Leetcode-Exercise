package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode049 {
	// 20190507
    public List<List<String>> groupAnagrams(String[] strs) {
    	HashMap<String, List<String>> anagramsMap = new HashMap<String, List<String>>();
    	for(String str : strs) {
    		char[] letters = str.toCharArray();
    		Arrays.sort(letters);
    		String key = String.valueOf(letters);
    		if(anagramsMap.containsKey(key)) {
    			anagramsMap.get(key).add(str);
    		} else {
    			ArrayList<String> list = new ArrayList<String>();
    			list.add(str);
    			anagramsMap.put(key, list);
    		}
    	}
    	Set<Map.Entry<String, List<String>>> entrySet = anagramsMap.entrySet();
    	Iterator<Map.Entry<String, List<String>>> itr = entrySet.iterator();
    	
    	List<List<String>> res = new ArrayList<List<String>>();
    	while(itr.hasNext()) {
    		res.add(itr.next().getValue());
    	}
    	return res;
    }

}
