package com.nichols.dsa.graphs

import java.util.*


class TopographicalGraphSort {
    private var v = 0
    private lateinit var  adj: Array<IntArray>

    fun solve(A: Int, B: Array<IntArray>): IntArray {
        v = A
        adj = B
        val stack  = Stack<Int>()

        // Mark all the vertices as not visited
        val visited = BooleanArray(v)
        for (i in 0 until v)
            visited[i] = false

        // Topological sort each vertices
        for (i in 0 until v)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack)

        return stack.toIntArray()
    }

    private fun topologicalSortUtil(v: Int, visited: BooleanArray, stack: Stack<Int>) {
        // Node is visited
        visited[v] = true
        var i: Int

        // Recursion for all adjacent verticies
        val it= adj[v].iterator()
        while (it.hasNext()) {
            i = it.next()
            if (!visited[i])
                topologicalSortUtil(i, visited, stack)
        }

        stack.push(v)
    }
}
class Graph(nodes: Int) {
    val v = nodes
    var e = 0
    val adjMatrix = Array(nodes) {IntArray(nodes)}

    fun addEdge(u : Int, v: Int){
        adjMatrix[u][v] = 1
        adjMatrix[v][u] = 1
        e++
    }

    fun main(){
        val g = Graph(4)
        g.addEdge(0,1)
        g.addEdge(1,2)
        g.addEdge(2,3)
        g.addEdge(3,4)
    }
}