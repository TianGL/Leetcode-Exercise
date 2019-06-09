package cn.geliang.stackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode103 {
    // 20190604
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        int level = 0;
        while (treeNodeQueue.size() != 0) {
            int size = treeNodeQueue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; ++i) {
                TreeNode treeNode = treeNodeQueue.pollFirst();
                if (level % 2 == 0) {
                    res.get(level).add(treeNode.val);
                } else {
                    res.get(level).add(0, treeNode.val);
                }
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            level++;
        }
        return res;
    }
}
