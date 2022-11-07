package com.nichols.dsa.sorting

fun addBinary(a: String, b: String): String? {
    if (a[0] == '0' && b[0] == '0')
        return "0"

    val result = StringBuilder()
    var sum = 0

    // Reverse traverse
    var i = a.length - 1
    var j = b.length - 1
    while (i >= 0 || j >= 0 || sum == 1) {

        sum += if (i >= 0) a[i] - '0' else 0
        sum += if (j >= 0) b[j] - '0' else 0

        result.append((sum % 2 + '0'.code).toChar())

        sum /= 2

        i--
        j--
    }

    var start = result.length - 1
    while (start >= 0 && result[start] == '0') {
        start--
    }

    if (start != result.length - 1)
        result.delete(start + 1, result.length)

    return result.reverse().toString()
}