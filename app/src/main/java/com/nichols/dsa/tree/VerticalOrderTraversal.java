package com.nichols.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col){
        node = _node;
        row = _row;
        col = _col;
    }
}

public class VerticalOrderTraversal {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
         class Pair {
            TreeNode t;
            int x;
            Pair(TreeNode t, int x) {
                this.t = t;
                this.x = x;
            }
        }
        public ArrayList < ArrayList < Integer >> verticalOrderTraversal(TreeNode root) {
            ArrayList < ArrayList < Integer >> ans = new ArrayList < ArrayList < Integer >> ();

            ArrayList < Integer > ar = new ArrayList < Integer > ();
            if (root == null) {
                return ans;
            }

            TreeMap < Integer, ArrayList < Integer >> tm = new TreeMap < > ();
            Queue < Pair > q = new LinkedList < Pair > ();
            q.add(new Pair(root, 0));

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int v = p.t.val;
                int x = p.x;
                ar = new ArrayList < Integer > ();
                if (tm.containsKey(x)) {
                    ar = tm.get(x);
                    ar.add(v);
                } else {
                    ar.add(v);
                }

                tm.put(x, ar);
                if (p.t.left != null) {
                    q.add(new Pair(p.t.left, x - 1));
                }
                if (p.t.right != null) {
                    q.add(new Pair(p.t.right, x + 1));
                }
            }
            for (int x: tm.keySet()) {
                ArrayList < Integer > f = tm.get(x);
                ans.add(f);
            }
            return ans;
        }
    }
}