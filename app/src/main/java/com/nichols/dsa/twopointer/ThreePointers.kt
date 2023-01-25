package com.nichols.dsa.twopointer

fun productsDistinct(A: Int):Int {
    var N = A
    var s = ""

    while (N > 0) {
        s += (N % 10 + '0'.code).toChar()
        N /= 10
    }

    s = s.reversed()

    val sz = s.length


    val hs = HashSet<Int>()

    for (i in 0 until sz) {
        var product = 1
        for (j in i until sz) {
            product *= (s[j] - '0')

            if (hs.contains(product))
                return -1
            else hs.add(product)
        }
    }
    return 1
}

fun reverse(input: String): String {
    val a = input.toCharArray()

    var r = a.size - 1
    var l = 0
    while (l < r) {
        val temp = a[l]
        a[l] = a[r]
        a[r] = temp
        l++
        r--
    }
    return String(a)
}
fun findSubString(A: String, B: String): String? {
    val len1 = A.length
    val len2 = B.length
    val no_of_chars = 256

    if (len1 < len2)
        return ""

    val hash_pat = IntArray(no_of_chars)
    val hash_str = IntArray(no_of_chars)

    for (i in 0 until len2) hash_pat[B[i].code]++
    var start = 0
    var start_index = -1
    var min_len = Int.MAX_VALUE

    var count = 0
    for (j in 0 until len1) {
        hash_str[A[j].code]++

        if (hash_str[A[j].code] <= hash_pat[A[j].code])
            count++


        if (count == len2) {


            while (hash_str[A[start].code] > hash_pat[A[start].code] || hash_pat[A[start].code] == 0) {
                if (hash_str[A[start].code] > hash_pat[A[start].code])
                    hash_str[A[start].code]--
                start++
            }


            val len_window = j - start + 1
            if (min_len > len_window) {
                min_len = len_window
                start_index = start
            }
        }
    }

    if (start_index == -1)
        return ""

    return A.substring(start_index, start_index + min_len)
}