package com.nichols.dsa.binarytrees;

public class TreeLinkRight {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;

        if(root.next != null)
            connect(root.next);

        if(root.left != null)
        {
            if(root.right != null)
            {
                root.left.next = root.right;
                root.right.next = getNextRight(root);
            }
            else
                root.left.next = getNextRight(root);

            connect(root.left);
        }
        else if (root.right != null)
        {
            root.right.next = getNextRight(root);
            connect(root.right);
        }
        else
            connect(getNextRight(root));
    }
    private TreeLinkNode getNextRight(TreeLinkNode A){
        TreeLinkNode temp = A.next;
        while(temp != null)
        {
            if(temp.left != null)
                return temp.left;
            if(temp.right != null)
                return temp.right;
            temp = temp.next;
        }
        return null;
    }
}
