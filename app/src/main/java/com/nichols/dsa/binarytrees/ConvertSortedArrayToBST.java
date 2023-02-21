package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(final int[] A) {
        if(A==null || A.length == 0)
            return null;

        return createBSTRecursive(A,0,A.length-1);
    }

    private TreeNode createBSTRecursive(int[] nums, int left, int right){
        if(left>right)
            return null;
        int mid = left+(right-left)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = createBSTRecursive(nums,left,mid-1);
        curr.right = createBSTRecursive(nums,mid+1,right);
        return curr;
    }
}
