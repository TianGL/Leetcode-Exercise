package cn.geliang.recursionAndTree;

public class Leetcode236 {
    // 20190615
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        if (leftSearch != null) {
            if (rightSearch != null) {
                return root;
            } else {
                return leftSearch;
            }
        } else {
            return rightSearch;
        }
    }
}
