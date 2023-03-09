package com.nichols.dsa.trie;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class MaxSubarrayXOR {
    public int solve(int[] A)
    {
        int n = A.length;
        trie t = new trie();
        return t.max_xor(A, n);
    }
    static class Node {
        public Node one, zero;
    }

    static class trie {
        Node root;
        public trie() { root = new Node(); }

        public void insert(int n)
        {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (bit == 0) {
                    if (temp.zero == null) {
                        temp.zero = new Node();
                    }
                    temp = temp.zero;
                }
                else {
                    if (temp.one == null) {
                        temp.one = new Node();
                    }
                    temp = temp.one;
                }
            }
        }

        public int max_xor_helper(int value)
        {
            Node temp = root;
            int current_ans = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (value >> i) & 1;
                if (bit == 0) {
                    if (temp.one != null) {
                        temp = temp.one;
                        current_ans += (1 << i);
                    }
                    else {
                        temp = temp.zero;
                    }
                }
                else {
                    if (temp.zero != null) {
                        temp = temp.zero;
                        current_ans += (1 << i);
                    }
                    else {
                        temp = temp.one;
                    }
                }
            }
            return current_ans;
        }

        public int max_xor(int[] arr, int n)
        {
            int max_val = 0;
            insert(arr[0]);
            for (int i = 1; i < n; i++) {
                max_val = Math.max(max_xor_helper(arr[i]),
                        max_val);
                insert(arr[i]);
            }
            return max_val;
        }
    }
}
