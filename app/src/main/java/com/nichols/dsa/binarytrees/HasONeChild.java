package com.nichols.dsa.binarytrees;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HasONeChild {
//    private HashMap<Integer,Integer> _hm = new HashMap<>();
    private Map<Integer, Integer> map;
    public int solve(TreeNode A) {
        if(checkEqualTree(A))
            return 1;
        else
            return 0;
    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        int sum = getTreeSum(root, map);

        if (sum == 0) {
            return map.getOrDefault(sum, 0) >= 2;
        }

        return sum % 2 == 0 ? map.containsKey(sum / 2) : false;
    }

    public int getTreeSum(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        int leftSum = getTreeSum(node.left, map);
        int rightSum = getTreeSum(node.right, map);

        int sum = node.val + leftSum + rightSum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public int solveEqualPartition(TreeNode A) {
//        if(A==null)
//            return -1;
//        int sum = getTreeSum(A);
//        if(sum==0)
//            return _hm.getOrDefault(sum,0)> 1 ? 1:0;
//        return sum % 2==0 && _hm.containsKey(sum/2)?1:0;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private int getTreeSum(TreeNode A){
//        if(A==null)
//            return 0;
//
//        int sum = A.val
//                + getTreeSum(A.left);
//        _hm.put(sum, _hm.getOrDefault(sum,0) + 1);
//        return sum;
//    }
    String hasOnlyOneChild(int[] A) {
        int size = A.length;
        int min, max;
        if (A[size - 1] > A[size - 2]) {
            max = A[size - 1];
            min = A[size - 2];
        } else {
            max = A[size - 2];
            min = A[size - 1];
        }

        for (int i = size - 3; i >= 0; i--) {
            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
