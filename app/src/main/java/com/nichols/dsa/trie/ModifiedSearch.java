package com.nichols.dsa.trie;

// Java trie based program to find the Number of
// triplets in array having subarray xor equal
class GFG
{
    static int lg = 31;
    static class TrieNode
    {
        TrieNode children[];
        int sum_of_indexes;
        int number_of_indexes;

        TrieNode()
        {
            children = new TrieNode[2];
            this.children[0] = null;
            this.children[1] = null;
            this.sum_of_indexes = 0;
            this.number_of_indexes = 0;
        }
    };

    static void insert(TrieNode node, int num, int index)
    {
        for (int bits = lg; bits >= 0; bits--)
        {
            int curr_bit = (num >> bits) & 1;

            if (node.children[curr_bit] == null)
                node.children[curr_bit] = new TrieNode();

            node = node.children[curr_bit];
        }

        node.sum_of_indexes += index;
        node.number_of_indexes++;
    }

    static int query(TrieNode node, int num, int index)
    {
        for (int bits = lg; bits >= 0; bits--)
        {
            int curr_bit = (num >> bits) & 1;

            if (node.children[curr_bit] == null)
                return 0;

            node = node.children[curr_bit];
        }

        int sz = node.number_of_indexes;
        int sum = node.sum_of_indexes;

        int ans = (sz * index) - (sum);

        return ans;
    }

    static int solveNumTriplets(int A[])
    {
        int n = A.length;
        int curr = 0;
        int tripletsCount = 0;

        TrieNode root = new TrieNode();

        for (int i = 0; i < n; i++)
        {
            int x = A[i];
            insert(root, curr, i);
            curr ^= x;

            tripletsCount += query(root, curr, i);
        }

        return tripletsCount;
    }
}