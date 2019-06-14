package cn.geliang.stackAndQueue;


public class Leetcode450 {
    // 20190614
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode parentNode = null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == key) {
                break;
            }
            parentNode = node;
            if (node.val < key) {
                node = node.right;
            } else if (node.val > key) {
                node = node.left;
            }
        }
        if (node == null) {
            return root;
        }

        TreeNode delNode = null;
        if (node.left != null) {
            delNode = findAndDelMaxNode(node.left, node, true);
        } else if (node.right != null) {
            delNode = findAndDelMinNode(node.right, node, false);
        } else {
            if (parentNode == null) {
                // 是根节点且是唯一节点
                return null;
            }
            // 是叶子节点
            if (parentNode.left == node) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
            return root;
        }

        // 替换节点值
        node.val = delNode.val;
        return root;

    }

    private TreeNode findAndDelMinNode(TreeNode node, TreeNode parent, boolean isLeft) {
        if (node == null) {
            return null;
        }

        // 找到最小的叶子节点
        if(node.left == null) {
            // 没有右子树直接将父节点指向node的方向指向node.right
            if (isLeft) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            node.right = null;
            return node;
        }
        return findAndDelMinNode(node.left, node, true);
    }

    private TreeNode findAndDelMaxNode(TreeNode node, TreeNode parent, boolean isLeft) {
        if (node == null) {
            return null;
        }

        // 找到最大的叶子节点
        if(node.right == null) {
            // 没有右子树直接将父节点指向node的方向指向node.left
            if (isLeft) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            node.left = null;
            return node;
        }
        return findAndDelMaxNode(node.right, node, false);
    }
}
