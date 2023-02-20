package com.nichols.dsa.binarytrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stk = new Stack();
        ArrayList<Integer> res = new ArrayList<>();
        stk.push(root);
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
        return res;
    }
    public int[] solve(TreeNode A)
    {
        if (A == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(A);

        ArrayList<Integer> l = new ArrayList<>();
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            if (t == null) {
                //l.add("#");
            }
            else {
                l.add(t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        int n = l.size();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = l.get(i);
        }
        return  answer;
    }
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
