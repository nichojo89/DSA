package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public ArrayList<Integer> solveRightView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList();
        rightView(A,result,0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null)
            return;
        if(currDepth == result.size())
            result.add(curr.val);
        rightView(curr.right,result,currDepth+1);
        rightView(curr.left,result,currDepth+1);
    }
}
