package com.nichols.dsa.binarytrees;

import com.nichols.dsa.Node;

public class BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int preIndex = 0;

    public TreeNode buildTree(int[] A, int[] B) {
        int len = A.length;
        return buildTree(A, B, 0, len - 1);
    }

    TreeNode buildTree(int[] in, int[] pre, int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        TreeNode tNode = new TreeNode(pre[preIndex++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(in, inStrt, inEnd, tNode.val);

        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    int search(int[] arr, int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}
