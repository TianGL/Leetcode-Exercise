package cn.geliang.stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {

    private static final int GO = 1;
    private static final int PRINT = 0;

    // 20190604
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> commandStack = new Stack<>();
        commandStack.push(new Command(GO,root));
        while (!commandStack.isEmpty()) {
            Command command = commandStack.peek();
            if (command.code == PRINT) {
                res.add(command.treeNode.val);
                commandStack.pop();
            } else {
                command.code=PRINT;
                if (command.treeNode.right != null) {
                    commandStack.push(new Command(GO, command.treeNode.right));
                }
                if (command.treeNode.left != null) {
                    commandStack.push(new Command(GO, command.treeNode.left));
                }
            }
        }
        return res;
    }

    private class Command {
        private int code;
        private TreeNode treeNode;

        public Command(int code, TreeNode treeNode) {
            this.code = code;
            this.treeNode = treeNode;
        }
    }
}
