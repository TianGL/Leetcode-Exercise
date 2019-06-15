package cn.geliang.recursionAndTree;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

public class Leetcode230 {
    // 20190615

    private static int GO = 1;
    private static int GET = 2;

    public int kthSmallest(TreeNode root, int k) {
        Stack<NodeAction> nodeActionStack = new Stack<>();
        nodeActionStack.push(new NodeAction(GO, root));
        int count = 0;
        while (nodeActionStack.size() != 0) {
            NodeAction nodeAction = nodeActionStack.pop();
            if (nodeAction.action == GET) {
                count++;
                if (count == k) {
                    return nodeAction.node.val;
                }
            } else {
                if (nodeAction.node.right != null) {
                    nodeActionStack.push(new NodeAction(GO, nodeAction.node.right));
                }
                nodeAction.action = GET;
                nodeActionStack.push(nodeAction);
                if (nodeAction.node.left != null) {
                    nodeActionStack.push(new NodeAction(GO, nodeAction.node.left));
                }
            }
        }
        return -1;
    }

    private class NodeAction {
        private int action;
        private TreeNode node;

        public NodeAction(int action, TreeNode node) {
            this.action = action;
            this.node = node;
        }
    }
}
