package com.nichols.dsa.graphs

import java.util.*

public int[] solve(int[] A) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] C = new int[A.length];

    for (int i = 0; i < A.length; i++) {
        int num = A[i];

        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }

        // Calculate the median
        if (maxHeap.size() > minHeap.size()) {
            C[i] = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            C[i] = minHeap.peek();
        } else {
            C[i] = (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    return C;
}


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