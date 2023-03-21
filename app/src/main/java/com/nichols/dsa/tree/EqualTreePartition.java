package com.nichols.dsa.tree;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//public class EqualTreePartition {
//    public int getAllElements(TreeNode root1, TreeNode root2) {
//        Stack<TreeNode> S1 = new Stack(), S2 = new Stack();
//        long result = 0L;
//        while(root1 != null || root2 != null || !S1.empty() || !S2.empty()){
//            while(root1 != null){
//                S1.push(root1);
//                root1 = root1.left;
//            }
//            while(root2 != null){
//                S2.push(root2);
//                root2 = root2.left;
//            }
//            if(S2.empty() || (!S1.empty() && S1.peek().val <= S2.peek().val)){
//                root1 = S1.pop();
//                result+= root1.val
//                root1 = root1.right;
//            } else {
//                root2 = S2.pop();
//                result += root2.val
//                root2 = root2.right;
//            }
//        }
//        int mod = (1000000000 + 7);
//
//        return (int)(result % mod);
//    }
//        @RequiresApi(api = Build.VERSION_CODES.N)
//        public int solve(TreeNode a) {
//            Map< Long, Integer > map = new HashMap< >();
//            long tot = populate(a, map);
//            // since total sum can also be zero
//            if (tot == 0)
//                return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
//            return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
//        }
//        @RequiresApi(api = Build.VERSION_CODES.N)
//        public long populate(TreeNode a, Map < Long, Integer > map) {
//            if (a == null)
//                return 0;
//            long sum = a.val + populate(a.left, map) + populate(a.right, map);
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//            return sum;
//        }
//
//}
