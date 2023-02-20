package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public ArrayList<Integer> solveRightView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        if(A == null)
            return result;

        q.offer(A);
        while(q.size() != 0){
            int size = q.size();
            for(int i =0; i < q.size(); i++){
                TreeNode curr = q.poll();
                if(i==0)
                    result.add(curr.val);
                if(curr.right != null)
                    q.offer(curr.right);
                if(curr.left != null)
                    q.offer(curr.left);
            }
        }
        return result;
    }

    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return result;

        q.offer(root);
        while(q.size() != 0){
            int size = q.size();
            for(int i =0; i < q.size(); i++){
                TreeNode curr = q.poll();
                if(i==0)
                    result.add(curr.val);
                if(curr.right != null)
                    q.offer(curr.right);
                if(curr.left != null)
                    q.offer(curr.left);
            }
        }
        return result;
    }
}
