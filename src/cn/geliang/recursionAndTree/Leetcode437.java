package cn.geliang.recursionAndTree;

public class Leetcode437 {
    // 20190614
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = findPath(root, sum);

        // 排除此节点，遍历子树
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    // 寻找包含root节点，和为sum的所有路径
    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) { // 可能包含负数，不返回
            res++;
        }
        // 继续遍历子节点
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;

    }
}
