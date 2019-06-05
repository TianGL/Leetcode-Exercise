package cn.geliang.searchTable;

import java.util.HashMap;

public class Leetcode149 {

	public static void main(String[] args) {
		Leetcode149 sol = new Leetcode149();
		HashMap<Point, Integer> map = new HashMap<Point, Integer>();
		int[] arr1 = {1, 2};
		Point p1 =  sol.new Point(arr1);
		int[] arr2 = new int[2];
		arr2[0] = 1; arr2[1] = 2;
		Point p2 =  sol.new Point(arr2);
		map.put(p1, 1);
		System.out.println(map.get(p2));
	}
	
	private class Point {
		public Integer x;
		public Integer y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(int[] pos) {
			x = pos[0];
			y = pos[1];
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
//			return super.hashCode();
			return (this.toString()).hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				return (p.x == x && p.y == y);
			}
			return false;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(x) + "," + String.valueOf(y);
		}
		
										
	}
	
	
	// 20190507
    public int maxPoints(int[][] points) {
    	
    	if(points.length == 1) {
    		return 1;
    	}
    	
        int res = 0;
        // 将点转化为自定义Point数据结构
        Point[] myPoints = new Point[points.length];
        for(int i = 0; i < points.length; ++i) {
        	myPoints[i] = new Point(points[i]);
        }
        
        HashMap<Point, Integer> record = new HashMap<Point, Integer>();
        for(int i = 0; i < myPoints.length-1; ++i) { // 第一个点
        	int numOfSamePoint = 0;
        	int curNums = 0;
        	record.clear();
        	for(int j = i+1; j < myPoints.length; ++j) { // 第二个点
        		
        		int deltX = myPoints[i].x - myPoints[j].x;
        		int deltY = myPoints[i].y - myPoints[j].y;
        		
        		if(deltX == 0 && deltY == 0) { // 处理相同点
        			numOfSamePoint++;
        			continue;
            	}
        		
        		int gcd = getGCD(deltX, deltY);
        		Point pointKey = null;
        		if (gcd != 0) {
        			pointKey = new Point(deltX/gcd, deltY/gcd);
        		} else {
        			pointKey = new Point(deltX, deltY);
        		}
        		record.put(pointKey, record.getOrDefault(pointKey, 0) + 1);
        		curNums = Math.max(curNums, record.get(pointKey));	
        	}
        	res = Math.max(res, curNums + 1 + numOfSamePoint);
        }
        return res;
    }
    
    // 计算最大公因数
    private int getGCD(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
    	return getGCD(b, a%b);
    }
}
