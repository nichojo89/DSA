package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderRecurssive(root, new ArrayList<>());
    }

    public List<Integer> preorderRecurssive(TreeNode A, List<Integer> B) {
        if(A == null)
            return B;
        B.add(A.val);

        preorderRecurssive(A.left,B);
        preorderRecurssive(A.right,B);
        return B;
    }
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //how many nodes to process?
            int size = queue.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                //take from front of line
                TreeNode curr = queue.remove();
                //add its value to current level list
                currLevel.add(curr.val);
                //add elements to queue/line
                //allows while loop to continue
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            //add to list of lists
            result.add(currLevel);
        }
        return result;
    }
}
