package cn.geliang.dp;

import java.util.HashMap;
import java.util.Map;

public class Leetcode337 {
    // 20190716

    // 节点->选取/不选去该节点对应的最大值
    private Map<TreeNode, int[]> map = new HashMap<>();

    public int rob(TreeNode root) {
        int[] count = {0,0};
        map.put(null, count);
        postOrderTravseral(root);
        return Math.max(map.get(root)[0], map.get(root)[1]);
    }

    private void postOrderTravseral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTravseral(node.left);
        postOrderTravseral(node.right);
        int[] count = new int[2]; // count[0]代表选取本点所得到的最大值，count[1]代表选不选取本点所得到的最大值
        count[0] = map.get(node.left)[1] + map.get(node.right)[1] + node.val;
        count[1] = Math.max(map.get(node.left)[0], map.get(node.left)[1])
                + Math.max(map.get(node.right)[0], map.get(node.right)[1]);
        map.put(node, count);
    }

    public static void main(String[] args) {
        Leetcode337 sol = new Leetcode337();
        sol.rob(new TreeNode(1));
    }
}
