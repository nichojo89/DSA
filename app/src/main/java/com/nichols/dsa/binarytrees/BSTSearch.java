package com.nichols.dsa.binarytrees;

public class BSTSearch {
    public int solve(DiameterOfTree.TreeNode A, int B) {
        DiameterOfTree.TreeNode temp = A;
        while(temp != null){
            if(temp.val == B)
                return 1;
            else if(temp.val < B)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return 0;
    }
}
