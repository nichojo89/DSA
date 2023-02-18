package com.nichols.dsa.binarytrees;


import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] postorderTraversal(TreeNode A) {
        Stack<TreeNode> stk = new Stack();
        ArrayList<Integer> res = new ArrayList<>();
        stk.push(A);
        while(!stk.isEmpty()){
            TreeNode topNode = stk.lastElement();
            stk.pop();

            res.add(topNode.val);
            if(topNode.left != null)
                stk.push(topNode.left);
            if(topNode.right != null)
                stk.push(topNode.right);
        }
        int n = res.size();
        for(int i = 0; i <n/2; i++){
            int a = i;
            int b = n-1-i;
             int temp = res.get(a);
             res.set(a,res.get(b));
             res.set(b,temp);
        }

        //TODO, refactor this
        // return answer
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
