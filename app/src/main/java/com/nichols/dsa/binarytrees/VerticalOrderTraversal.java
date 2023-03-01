package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode
import java.util.ArrayList;

public class VerticalOrderTraversal {
    public int t2Sum(TreeNode A, int B) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = treeToList(A, a1);

        int start = 0;
        int end = a2.size() - 1;

        while (start < end) {
            if (a2.get(start) + a2.get(end) == B)
            {
                //found pair
                return 1;
            }

            if (a2.get(start) + a2.get(end) > B)
            {
                end--;
            }

            if (a2.get(start) + a2.get(end) < B)
            {
                start++;
            }
        }
        //not pair :(
        return 0;
    }

    private ArrayList<Integer> treeToList(TreeNode node, ArrayList<Integer> list)
    {
        if (node == null)
            return list;

        treeToList(node.left, list);
        list.add(node.val);
        treeToList(node.right, list);

        return list;
    }
}
