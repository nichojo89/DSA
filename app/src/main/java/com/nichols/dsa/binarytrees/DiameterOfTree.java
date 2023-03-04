package com.nichols.dsa.binarytrees;

public class DiameterOfTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int solveDiameterOfTree(TreeNode A) {
        int[] diameter = new int[1];
        height(A, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public int isBalanced(TreeNode A)
    {
        int lh;
        int rh;

        if (A == null)
            return 1;

        lh = height(A.left);
        rh = height(A.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(A.left) != 0
                && isBalanced(A.right) != 0)
            return 1;

        return 0;
    }
    int height(TreeNode node)
    {
        if (node == null)
            return 0;
        return 1
                + Math.max(height(node.left),
                height(node.right));
    }
}
