package cn.geliang.stackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    // 20190605

    private class NodeAndLevel {
        private TreeNode node;
        private int level;

        public NodeAndLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<NodeAndLevel> nodeQueue = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        nodeQueue.add(new NodeAndLevel(root, 0));
        while (nodeQueue.size() != 0) {
            NodeAndLevel nodeAndLevel = nodeQueue.poll();
            TreeNode node = nodeAndLevel.node;
            int level = nodeAndLevel.level;
            if (level == res.size()) {
                // 需要新的一行来存储新的一层
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                nodeQueue.add(new NodeAndLevel(node.left, level+1));
            }
            if (node.right != null) {
                nodeQueue.add(new NodeAndLevel(node.right, level+1));
            }
        }
        return res;
    }
}
