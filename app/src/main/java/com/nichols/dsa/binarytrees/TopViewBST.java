package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewBST {
    public ArrayList<Integer> solve(TreeNode A) {
        class QueueHD {
            TreeNode node;
            int hd;
            public QueueHD(TreeNode n, int hd){
                this.node = n;
                this.hd = hd;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(A==null)
            return ans;
        Queue<QueueHD> q = new LinkedList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        int min = 0;
        int max = 0;

        q.add(new QueueHD(A,0));
        while(!q.isEmpty()){
            QueueHD curr = q.poll();

            if(!hm.containsKey(curr.hd))
                hm.put(curr.hd,curr.node.val);

            if(curr.node.left != null){
                min = Math.min(min, curr.hd-1);
                q.add(new QueueHD(curr.node.left,
                        curr.hd-1));
            }

            if(curr.node.right != null){
                max= Math.max(max,curr.hd+1);
                q.add(new QueueHD(curr.node.right,
                        curr.hd+1));
            }
        }
        for(; min <= max; min++)
            ans.add(hm.get(min));

        return ans;
    }
}
