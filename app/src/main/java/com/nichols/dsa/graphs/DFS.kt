package com.nichols.dsa.graphs

fun main(){
    var A = arrayOf(IntArray(10))
    var visited = BooleanArray(A.size)

    for(i in A.indices)
        if(!visited[i])
            dfs(A,i,visited)
}

fun dfs(graph: Array<IntArray>, src: Int, visited: BooleanArray){
    visited[src] = true;
    for(nbr in graph[src])
        if(!visited[nbr])
            dfs(graph,nbr,visited)
}