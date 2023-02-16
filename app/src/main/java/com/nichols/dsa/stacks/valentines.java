package com.nichols.dsa.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class valentines {
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    public int[] inorderTraversal(TreeNode A) {
        if(A == null)
            return null;

        Stack<TreeNode> s = new Stack();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeNode curr = A;

        while(curr != null || s.size() > 0)
        {
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            //add to array
            ans.add(curr.val);
            curr = curr.right;
        }
        //this could be better
        int n = ans.size();
        int[] answer = new int[n];
        for(int i =0; i < n; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    public  int[] findNextGreaterElements(int[] input)
    {
        int n = input.length;
        int[] ans= new int[n];
        if (n ==0) {
            return ans;
        }

        // do for each element
        for (int i = 0; i < input.length; i++)
        {
            // keep track of the next greater element for element `input[i]`
            int next = -1;

            // process elements on the right of element `input[i]`
            for (int j = i + 1; j < input.length; j++)
            {
                // break the inner loop at the first larger element on the
                // right of element `input[i]`
                if (input[j] > input[i])
                {
                    next = input[j];
                    break;
                }
            }

            ans[i] = next;
        }
        return ans;
    }
}
