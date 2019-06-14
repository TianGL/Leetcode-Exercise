package cn.geliang.recursionAndTree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    // 20190614
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        // 如果已经是叶子节点，对于值为sum的节点，放入res中
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> leafVal = new ArrayList<>();
                leafVal.add(root.val);
                res.add(leafVal);
            }
            return res;
        }

        List<List<Integer>> pathLeft = pathSum(root.left, sum - root.val);
        for (List<Integer> leftRes : pathLeft) {
            leftRes.add(0, root.val);
            res.add(leftRes);
        }

        List<List<Integer>> pathRight = pathSum(root.right, sum - root.val);
        for (List<Integer> rightRes : pathRight) {
            rightRes.add(0, root.val);
            res.add(rightRes);
        }
        return res;

    }
}
