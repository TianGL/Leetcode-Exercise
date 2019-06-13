package cn.geliang.recursionAndTree;

public class Leetcode222 {
    // 20190613
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) {
            return 0;
        }
        if (h == 1) {
            return 1;
        }
        int rightHeight = height(root.right);
        // 根据右子树的高度判断左子树是否为满二叉树
        // 若rightHeight == h - 1 则左子树比为满二叉树， 节点数为 2^(h-1) -1 加上根节点，可缺点节点数为2^(h-1)
        // 反之，则右子树为满二叉树， 节点数为 2^(h-2) -1 加上根节点，可缺点节点数为2^(h-1)
        return (rightHeight == h - 1) ? (1 << (h-1)) + countNodes(root.right) : (1 << (h-2)) + countNodes(root.left);
    }

    // 计算完全二叉树树高
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left);
    }
}
