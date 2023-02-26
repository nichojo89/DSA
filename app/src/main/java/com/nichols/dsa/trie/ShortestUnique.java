package com.nichols.dsa.trie;

import java.util.ArrayList;

public class ShortestUnique {
    static final int MAX  = 256;

    // Maximum length of an input word
    static final int MAX_WORD_LEN = 500;

    // Trie Node.
    static class TrieNode
    {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency
        TrieNode() {
            freq =1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }
    static TrieNode root;
    static String[] prefix(String[] A) {
        int n = A.length;
        root = new TrieNode();
        root.freq = 0;
        for (String s : A)
            insert(s);

        char[] prefix = new char[MAX_WORD_LEN];

        findPrefixesUtil(root, prefix, 0);
        return A;
    }

    // Method to insert a new string into Trie
    static void insert(String str)
    {
        int len = str.length();
        TrieNode pCrawl = root;

        for (int level = 0; level<len; level++)
        {
            int index = str.charAt(level);

            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;

            pCrawl = pCrawl.child[index];
        }
    }

    static void findPrefixesUtil(TrieNode root, char[] prefix, int ind)
    {
        if (root == null)
            return;

        if (root.freq == 1)
        {
            prefix[ind] = '\0';
            int i = 0;
            while(prefix[i] != '\0')
                System.out.print(prefix[i++]);

            return;
        }

        for (int i=0; i<MAX; i++)
        {
            if (root.child[i] != null)
            {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind+1);
            }
        }
    }
}