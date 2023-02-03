package com.nichols.dsa.patternMatching

fun main(){
    val two = solvePeriodOfString("abababab")
    val one = solvePeriodOfString("aaaa")
}


fun isRepeated(A:String): Boolean {
    val z = computeLPSArray(A)
    val n = A.length
    var len = z.last()
    return len > 0 && n % (n - len) === 0
}

fun solvePeriodOfString(A: String): Int {
    val z = computeLPSArray(A)
    val n = A.length
    for(i in 1 until n)
        if(i + z[i]==n)
            return i
    return 0
}

fun computeLPSArray(A:String): IntArray{
    val m = A.length
    val ans = IntArray(m)
    var len = 0
    var i = 1

    while(i<m){
        if(A[i] == A[len]){
            len++
            ans[i] = len
            i++
        } else {
            if(len != 0 )
                len = ans[len-1]
            else {
                ans[i] = len
                i++
            }
        }
    }
    return ans
}


fun solvePeriod(A: String): Int {
    val Z = getZarr(A)
    val n = A.length
    for (i in 1 until n) {
        if (i + Z[i] === n) {
            return i
        }
    }
    return n
}

fun getZarr(str: String): ArrayList<Int> {
    val n = str.length
    // Z array
    val Z = ArrayList<Int>()
    for (i in 0 until n) Z.add(0)
    var L: Int
    var R: Int
    var k: Int
    // [L, R] make a window which matches with prefix of str
    R = 0
    L = R
    for (i in 1 until n) {
        // if i > R nothing matches so we will calculate Z[i] using naive way
        if (i > R) {
            R = i
            L = R
            // R - L = 0 in starting, so it will start checking from 0'th index
            while (R < n && str[R - L] == str[R]) R++
            Z[i] = R - L
            R--
        } else {
            // k = i - L so k corresponds to number which matches in [L,R] interval
            k = i - L
            // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
            if (Z[k] < R - i + 1) Z[i] = Z[k] else {
                // else start from R and check manually
                L = i
                while (R < n && str[R - L] == str[R]) R++
                Z[i] = R - L
                R--
            }
        }
    }
    return Z
}