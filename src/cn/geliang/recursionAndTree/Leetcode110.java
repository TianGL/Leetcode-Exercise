package cn.geliang.recursionAndTree;

public class Leetcode110 {
    // 20190613
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /*************************************/
    // bottom to up
    public boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHi = dfsHeight(root.left);
        if (leftHi == -1) {
            return -1;
        }
        int rightHi = dfsHeight(root.right);
        if (rightHi == -1) {
            return -1;
        }

        if (Math.abs(leftHi - rightHi) > 1) {
            return -1;
        }
        return Math.max(leftHi, rightHi) + 1;
    }
}
