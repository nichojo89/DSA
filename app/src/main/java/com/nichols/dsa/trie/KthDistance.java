package com.nichols.dsa.trie;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class KthDistance {
    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;

    public int solvefindDistance(TreeNode A, int B, int C)
    {
        d1 = -1;
        d2 = -1;
        dist = 0;
        TreeNode lca = findDistUtil(A, B, C, 1);

        if (d1 != -1 && d2 != -1)
        {
            return dist;
        }

        if (d1 != -1)
        {
            dist = findLevel(lca, C, 0);
            return dist;
        }

        if (d2 != -1)
        {
            dist = findLevel(lca, B, 0);
            return dist;
        }
        return -1;
    }

    static int findLevel(TreeNode root, int k, int level)
    {
        if (root == null)
            return -1;

        if (root.val == k)
            return level;

        int l = findLevel(root.left, k, level + 1);
        return (l != -1)? l : findLevel(root.right, k,
                level + 1);
    }

    public static TreeNode findDistUtil(TreeNode root, int n1, int n2, int lvl)
    {
        if (root == null)
        {
            return null;
        }

        if (root.val == n1)
        {
            d1 = lvl;
            return root;
        }
        if (root.val == n2)
        {
            d2 = lvl;
            return root;
        }

        TreeNode left_lca = findDistUtil(root.left, n1, n2, lvl + 1);
        TreeNode right_lca = findDistUtil(root.right, n1, n2, lvl + 1);

        if (left_lca != null && right_lca != null)
        {
            dist = (d1 + d2) - 2 * lvl;
            return root;
        }

        return (left_lca != null)? left_lca : right_lca;
    }
    public TreeNode flatten(TreeNode node)
    {

        if (node == null)
            return null;

        if (node.left == null && node.right == null)
            return node;

        if (node.left != null) {

            flatten(node.left);

            TreeNode tempNode = node.right;
            node.right = node.left;
            node.left = null;

            TreeNode curr = node.right;
            while (curr.right != null)
                curr = curr.right;

            curr.right = tempNode;
        }

        flatten(node.right);
        return node;
    }
}
