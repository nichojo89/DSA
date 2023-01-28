package com.nichols.dsa.hashing

fun main(){
    solveCountPairSum(intArrayOf(1, 2, 1, 2),3)
}
fun solveCountPairSum(A: IntArray, B: Int): Int {
    var count = 0
    for(i in A.indices) {
        val a = A[i]
        val b = B-a
        for(j in i+1 until A.size){
            if(A[j] == b)
                count++
        }
    }
    return count
}

fun solveScaler(A: IntArray, B: Int): Int {
    val freq: MutableMap<Int, Int> = HashMap()
    val mod = (1e9 + 7).toInt()
    var ans: Long = 0
    for (i in A.indices) {
        if (freq.containsKey(B - A[i])) {
            ans = (ans + freq[B - A[i]]!!) % mod
        }
        freq[A[i]] = freq.get(A[i])!! + 1
    }
    return ans.toInt()
}

fun books(A: IntArray, m: Int): Int {
    val n = A.size
    var sum = 0

    if (n < m)
        return -1

    var max = A[0]


    // Count # of pages
    for (i in A.indices) {
        sum += A[i]
        max = if (A[i] > max) A[i] else max
    }

    var start = A[n - 1]
    var end = sum
    var result = Int.MAX_VALUE

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (isPossible(A,  m, mid)) {
            result = mid
            end = mid - 1
        }
        else
            start = mid + 1
    }

    return result
}

fun nthMagicNo(A: Int): Int {
    var n = A
    var pow = 1
    var answer = 0

    while (n != 0) {
        pow *= 5

        if ((n and 1) == 1)
            answer += pow
        n = n shr 1
    }
    return answer
}

fun isPossible(A: IntArray, B: Int, currentMin: Int): Boolean {
    var students = 1
    var currentSum = 0

    for (i in A.indices) {
        currentSum += A[i]
        if (currentSum > currentMin) {
            students++
            currentSum = A[i]
        }
    }
    return students <= B
}



//////////x---xxx


fun gcd(a: Int, b: Int): Int =
    if (a == 0) b else gcd(b % a, a)

fun divTermCount(a: Int, b: Int, lcm: Int, num: Int): Int =
    num / a + num / b - num / lcm

fun solveAthTerm(a: Int, b: Int, n: Int): Int {
    var low = 1
    var high = Int.MAX_VALUE
    var mid: Int
    val lcm = a * b / gcd(a, b)
    while (low < high) {
        mid = low + (high - low) / 2
        if (divTermCount(a, b, lcm, mid) < n) low = mid + 1 else high = mid
    }
    return low
}