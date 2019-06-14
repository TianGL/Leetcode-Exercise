package cn.geliang.recursionAndTree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class Leetcode098 {
    // 20190614
    private static boolean GO = false;
    private static boolean GET = true;

    // 中序遍历访问后，应该是递增顺序
    public boolean isValidBST(TreeNode root) {
        Stack<NodeAction> nodeActionStack = new Stack<>();
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        nodeActionStack.push(new NodeAction(GO, root));
        while (nodeActionStack.size() != 0) {
            NodeAction nodeAction = nodeActionStack.pop();
            if (nodeAction.action == GET) {
                if (pre != null && pre.val >= nodeAction.node.val) {
                    return false;
                }
                pre = nodeAction.node;
            } else {
                nodeAction.action = GET;
                if (nodeAction.node.right != null) {
                    nodeActionStack.push(new NodeAction(GO, nodeAction.node.right));
                }
                nodeActionStack.push(nodeAction);
                if (nodeAction.node.left != null) {
                    nodeActionStack.push(new NodeAction(GO, nodeAction.node.left));
                }
            }
        }
        return true;
    }

    private class NodeAction{
        private boolean action;
        private TreeNode node;

        public NodeAction(boolean action, TreeNode node) {
            this.action = action;
            this.node = node;
        }
    }
}
