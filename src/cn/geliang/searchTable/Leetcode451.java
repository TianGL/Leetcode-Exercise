package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Leetcode451 {
	// 20190506
    public String frequencySort(String s) {
        char[] Letters = s.toCharArray();
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for(char c : Letters) {
        	freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Entry<Character, Integer>> priorityQueue =
        		new PriorityQueue<Entry<Character,Integer>>((a, b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(freq.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()) {
        	Entry<Character, Integer> entry = priorityQueue.poll();
        	for(int i = 0; i < entry.getValue(); ++i) {
        		sb.append(entry.getKey());
        	}
        }
        return sb.toString();
        
    }
}
