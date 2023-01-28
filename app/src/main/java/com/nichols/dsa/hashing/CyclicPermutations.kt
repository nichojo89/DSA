package com.nichols.dsa.hashing

fun solveCyclePermutation(A: String, B: String): Int {
    var b = B
    b += b
    b = b.substring(0, b.length - 1)

    var ans = 0
    val s = "$A$$b"
    val n = s.length

    val z = IntArray(n)
    createKMP(s, z)
    for (i in 1 until n)
        if (z[i] == A.length)
            ans++

    return ans
}

fun createKMP(s: String, z: IntArray) {
    var l = 0
    var r = 0
    val n = s.length
    for (i in 1 until n) {
        if (i > r) {
            l = i
            r = i
            while (r < n && s[r - l] == s[r])
                r++

            z[i] = r - l
            r--
        } else {
            val k = i - l
            if (z[k] < r - i + 1)
                z[i] = z[k]
            else {
                l = i
                while (r < n && s[r - l] == s[r])
                    r++
                z[i] = r - l
                r--
            }
        }
    }
}

