package cn.geliang.array;

public class Leetcode088 {
	//20190420
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int k = m + n - 1;
        while( 0 <= i || 0 <= j) {
        	if( i < 0 || (0 <=j && nums1[i] < nums2[j]) ) {
        		nums1[k--] = nums2[j--];
        	} else {
        		nums1[k--] = nums1[i--];
        	}
        }
    }
}
