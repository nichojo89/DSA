package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class LargestBST {
    public int solve(TreeNode A)
    {
        return largestBST(A).size;
    }

    static class NodeMetaData {
        int min;
        int max;
        int size;
        boolean isBST;

        NodeMetaData() {}

        NodeMetaData(int size, int max, int min, boolean isBST)
        {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    static NodeMetaData largestBST(TreeNode A)
    {
        if (A == null)
            return new NodeMetaData(0, Integer.MIN_VALUE,
                    Integer.MAX_VALUE, true);

        NodeMetaData left = largestBST(A.left);
        NodeMetaData right = largestBST(A.right);

        NodeMetaData returnInfo = new NodeMetaData();

        returnInfo.min = Math.min(left.min, A.val);
        returnInfo.max = Math.max(right.max, A.val);
        returnInfo.isBST = left.isBST && right.isBST
                && A.val > left.max
                && A.val < right.min;
        if (returnInfo.isBST)
            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size = Math.max(left.size, right.size);

        return returnInfo;
    }
}

