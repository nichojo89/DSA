package com.nichols.dsa.tree;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class EqualTreePartition {
        @RequiresApi(api = Build.VERSION_CODES.N)
        public int solve(TreeNode a) {
            Map< Long, Integer > map = new HashMap< >();
            long tot = populate(a, map);
            // since total sum can also be zero
            if (tot == 0)
                return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
            return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public long populate(TreeNode a, Map < Long, Integer > map) {
            if (a == null)
                return 0;
            long sum = a.val + populate(a.left, map) + populate(a.right, map);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }

}
