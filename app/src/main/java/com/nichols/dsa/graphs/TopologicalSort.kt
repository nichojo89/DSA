package com.nichols.dsa.graphs

import java.util.*




fun solve(A: Int, B: Array<IntArray>): Int {
    val graph = Array<MutableList<Int>>(A + 1) { mutableListOf<Int>() }
    for ((u, v) in B) {
        graph[u].add(v)
    }
    val visited = BooleanArray(A + 1)
    val recursionStack = BooleanArray(A + 1)
    for (node in 1..A) {
        if (!visited[node] && hasCycleUtil(node, graph, visited, recursionStack)) {
            return 1
        }
    }
    return 0
}

fun hasCycleUtil(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray, recursionStack: BooleanArray): Boolean {
    visited[node] = true
    recursionStack[node] = true
    for (neighbor in graph[node]) {
        if (!visited[neighbor] && hasCycleUtil(neighbor, graph, visited, recursionStack)) {
            return true
        } else if (recursionStack[neighbor]) {
            return true
        }
    }
    recursionStack[node] = false
    return false
}