package cn.geliang.searchTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode447 {
	
	// 20150507
    public int numberOfBoomerangs(int[][] points) {
    	
    	int res = 0;
    	
        for(int i = 0; i < points.length; ++i) {
        	HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
        	for(int j = 0; j < points.length; ++j) { // 构建没一点到第i个点的距离表
        		int curDist = calcDist(points[i], points[j]);
        		dist.put(curDist, dist.getOrDefault(curDist, 0) + 1);
        	}
        	List<Integer> allDist = new ArrayList<Integer>(dist.values());
        	for(int perDist : allDist) {
        		if(perDist > 1) {
        			res += perDist * (perDist-1);
        		}
        	}
        }
        return res;
    }
    
    private int calcDist(int[] p1, int[] p2) {
    	return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

}
