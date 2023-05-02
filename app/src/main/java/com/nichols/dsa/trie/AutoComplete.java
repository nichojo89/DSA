package com.nichols.dsa.trie;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class AutoComplete {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Trie trie = new Trie();

        int n = scan.nextInt();

        for(int i = 0; i < n; i++){
            String word = scan.next();
            int weight = scan.nextInt();
            //Insert here
            trie.insert(word,weight);
        };

        int m = scan.nextInt();
        for(int i = 0; i < m; i++){
            String prefix = scan.next();
            //TODO search
            List<String> result = trie.search(prefix);
            for(String word:result)
                System.out.print(word + " ");

            System.out.println();
        }

    }
}

class WordWeight implements Comparable<WordWeight>{
    String word;
    int weight;

    WordWeight(String wrd, int wght)
    {
        word = wrd;
        weight = wght;
    }
    @Override
    public int compareTo(WordWeight o) {
        return Integer.compare(o.weight, this.weight);
    }
}
class Trie{
    TrieNode root = new TrieNode();

    private int getWeight(String word) {
        String[] parts = word.split(":");
        return Integer.parseInt(parts[1]);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void insert(String word, int weight) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            //Add char if it doesnt exist
            node.children.putIfAbsent(c,new TrieNode());
            //Set node to current node
            node = node.children.get(c);
        }
        //set Is word end to true
        node.isWord = true;
        node.words.add(word);

        Collections.sort(node.words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(getWeight(o2),getWeight(o1));
            }
        });

        if(node.words.size() > 5)
            node.words.remove(5);
    }

    List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            node = node.children.get(c);
            //Char node found in TrieNode children.
            if (node == null)
                return Collections.singletonList("-1");
        }

        if(node.isWord)
            result.addAll(node.words);
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty() && result.size() < 5){
                node = queue.poll();
                for(TrieNode child : node.children.values()){
                    if(child.isWord){
                        result.addAll(child.words);
                        if(result.size() >= 5)
                            break;
                    }
                    queue.offer(child);
                }
        }
        if(result.isEmpty())
                result.add("-1");

        return result;
    }
}
class TrieNode {
    Map<Character, TrieNode> children;
    Boolean isWord;
    List<String> words;
    TrieNode(){
        children = new HashMap<>();
        isWord = false;
        words = new ArrayList<>();
    }
}
