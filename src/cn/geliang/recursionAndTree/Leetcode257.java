package cn.geliang.recursionAndTree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    // 20190614
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        if (root.left == null && root.right==null) {
            // 已经是叶子节点，放入res中
            res.add(String.valueOf(root.val));
            return res;
        }

        // 若不是叶子节点
        // 获取左子树的所有路径
        List<String> leftRes = binaryTreePaths(root.left);
        // 获取右子树的所有路径
        List<String> rigntRes = binaryTreePaths(root.right);

        // 构建到每个叶节点下的路径
        for (String leftPath : leftRes) {
            res.add(root.val + "->" + leftPath);
        }
        for (String rightPath : rigntRes) {
            res.add(root.val + "->" + rightPath);
        }
        return res;

    }
}
