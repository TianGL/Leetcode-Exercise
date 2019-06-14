package cn.geliang.recursionAndTree;

public class Leetcode129 {
    // 20190614
    public int sumNumbers(TreeNode root) {
        return getSumNumbers(root, 0);
    }

    private int getSumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum*10 + root.val;
        }

        int leftSum = getSumNumbers(root.left, sum*10 + root.val);
        int rightSum = getSumNumbers(root.right, sum*10 + root.val);
        return leftSum + rightSum;
    }
}
