package com.nichols.dsa.binarytrees;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Encryption {
    public ArrayList<Integer> solveSerialize(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(q.size() != 0){
            TreeNode cur = q.peek();
            q.remove();
            if(cur == null){
                ans.add(-1);
                continue;
            }

            ans.add(cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }
        return ans;
    }
    public TreeNode solveDeserialize(ArrayList<Integer> A) {
        if(A==null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        q.add(root);
        for(int i = 1; i < A.size(); i++){
            TreeNode parent = q.poll();
            if(A.get(i) != -1){
                TreeNode left = new TreeNode(A.get(i));
                parent.left = left;
                q.add(left);
            }
            if(A.get(++i) != -1){
                TreeNode right = new TreeNode(A.get(i));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
