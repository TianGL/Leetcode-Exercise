package cn.geliang.recursionAndTree;

public class Leetcode404 {
    // 20190613
    public int sumOfLeftLeaves(TreeNode root) {
        return getSumOfLeftLeaves(root, false, 0);
    }

    private int getSumOfLeftLeaves(TreeNode root, boolean isLeftNode, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null) {
            if (isLeftNode) {
                return sum + root.val;
            } else {
                return sum;
            }
        }
        sum = getSumOfLeftLeaves(root.left, true, sum);
        sum = getSumOfLeftLeaves(root.right, false, sum);
        return sum;
    }
}
