package com.nichols.dsa.graphs

import java.util.*

class Temp {
    fun solve(A: Int, B: Array<IntArray>): Int {
        adj = ArrayList(maxn)
        //initialize visited array and new up adjacencty list until maxn
        for(i in 0..maxn){
            visited[i] = 0
            adj!!.add(ArrayList())
        }
        //Create adjacency list
        for(edge in B)
            adj.get(edge[0]).add(edge[1])

        return isReachable(1,A)
    }
    companion object {
        //Declare maxn: Int, visited, IntArray(maxn), adj, ArrayList<ArrayList<Int>>(maxn)
        val maxn = 100009
        val visited = IntArray(maxn)
        var adj = ArrayList<ArrayList<Int>>(maxn)

        fun isReachable(source: Int, destination: Int): Int{
            //check for a match
            if(source == destination)
                return 1
            //create a queue and
            // add the source first
            val q: Queue<Int> = ArrayDeque()
            var s = source
            q.add(s)
            //set source as visited
            visited[s] = 1
            while(q.isNotEmpty()){
                //set source to front of que
                s = q.poll()
                //for each vecot rin the adj list of source
                for(v in adj[s]){
                    if(v == destination)
                        return 1
                    if(visited[v]==0){
                        visited[v]==1
                        q.offer(v)
                    }
                }
            }
            return 0
        }
    }
}
