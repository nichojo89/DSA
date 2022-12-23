package com.nichols.dsa.prime

fun solve(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
    val l1 = Point()
    val r1 = Point()
    val l2 = Point()
    val r2 = Point()
    l1.x = A
    l1.y = B
    r1.x = C
    r1.y = D
    l2.x = E
    l2.y = F
    r2.x = G
    r2.y = H

    return if (doOverlap(l1, r1, l2, r2)) 1 else 0
}

class Point {
    var x = 0
    var y = 0
}

fun doOverlap(l1: Point, r1: Point, l2: Point, r2: Point): Boolean {
    // if rectangle has area 0, no overlap
    if (l1.x == r1.x || l1.y == r1.y || r2.x == l2.x || l2.y == r2.y) return false

    // If one rectangle is on left side of other
    if (l1.x > r2.x || l2.x > r1.x) {
        return false
    }

    // If one rectangle is above other
    return if (r1.y > l2.y || r2.y > l1.y) {
        false
    } else true
}