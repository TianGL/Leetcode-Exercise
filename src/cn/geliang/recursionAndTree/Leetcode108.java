package cn.geliang.recursionAndTree;

public class Leetcode108 {
    // 20190615
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertSortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode convertSortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }
        int mid = lo + (hi - lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertSortedArrayToBST(nums, lo, mid);
        root.right = convertSortedArrayToBST(nums, mid+ 1, hi);
        return root;

    }
}
