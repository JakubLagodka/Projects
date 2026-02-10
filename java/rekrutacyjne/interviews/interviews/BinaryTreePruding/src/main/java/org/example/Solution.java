package org.example;

public class Solution {
    public static TreeNode pruneTree(TreeNode root) {
        if (root.left != null) {
            pruneTree(root.left);
            if (root.left.left == null && root.left.right == null && root.left.val == 0) {
                root.left = null;
            }
        }

        if (root.right != null) {
            pruneTree(root.right);
            if (root.right.left == null && root.right.right == null && root.right.val == 0) {
                root.right = null;
            }
        }

        return root;
    }
}