package com.nichols.dsa.patternMatching

import java.util.*

fun solveBoringString(s: String): Int {
    var odd = ""
    var even = ""

    //Add characters to odd or even string based on ASCII
    for (i in 0 until s.length) {
        val c = s[i]
        if (c.code % 2 == 0)
            odd += c
        else
            even += c
    }

    // Sort Odd Array
    val oddArray = odd.toCharArray()
    Arrays.sort(oddArray)
    odd = String(oddArray)

    //Sort Even Array
    val evenArray = even.toCharArray()
    Arrays.sort(evenArray)
    even = String(evenArray)

    if (check(odd + even))
        return 1
    else if (check(even + odd))
        return 1

    return 0
}

fun check(s: String): Boolean {
    var res = true
    var i = 0
    while (i + 1 < s.length) {
        res = res and (Math.abs(
            s[i] -
                    s[i + 1]
        ) != 1)
        ++i
    }
    return res
}




fun solve(A: String): Int {
    var odd = ""
    var even = ""
    // odd and even stores odd and even characters respective
    for (i in 0 until A.length) {
        val c = A[i]
        if (c.code % 2 == 0) odd += c else even += c
    }
    var ar = odd.toCharArray()
    Arrays.sort(ar)
    odd = String(ar)
    ar = even.toCharArray()
    Arrays.sort(ar)
    even = String(ar)
    // check if either (odd + even) or (even + odd) has no boring substrings
    if (check(odd + even)) return 1 else if (check(even + odd)) return 1
    return 0
}