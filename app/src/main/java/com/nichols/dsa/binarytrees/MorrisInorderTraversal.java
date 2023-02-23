package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;

public class MorrisInorderTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode current, pre;

        if (A == null)
            return ans;

        current = A;
        while (current != null)
        {
            if (current.left == null)
            {
                ans.add(current.val);
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        return ans;
    }
}
