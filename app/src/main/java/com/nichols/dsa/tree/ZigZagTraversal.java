package com.nichols.dsa.tree;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
     public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList();
        ArrayList<ArrayList<Integer>> wrapList = new ArrayList<>();

        if (A == null)
            return wrapList;

        queue.offer(A);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList < Integer > subList = new ArrayList < Integer > (levelNum);
            for (int i = 0; i < levelNum; i++) {
                int index = i;
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag == true) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }
}
