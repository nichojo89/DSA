package com.nichols.dsa.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class PathInDirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if(isPathDFS(B,B.size(),1,A))
                return 1;
            else
                return 0;
    }
    public static boolean isPathDFS(ArrayList<ArrayList<Integer>> graph, int nodes, int source, int end){
        boolean[] visited = new boolean[nodes];
        for(int i = 0; i < nodes; ++i){
            visited[i] = false;
        }

        Stack<Integer> traversal = new Stack<>();
        traversal.push(source);
        visited[source-1] = true;

        while(!traversal.empty()){
            source = traversal.pop();

            for(int i = 0; i < graph.get(source-1).size(); ++i){
                if(graph.get(source-1).get(i) == end)
                    return true;

                if(!visited[graph.get(source-1).get(i)-1]){
                    traversal.push(graph.get(source-1).get(i));
                    visited[graph.get(source-1).get(i)-1] = true;
                }
            }
        }

        return false;
    }
}
