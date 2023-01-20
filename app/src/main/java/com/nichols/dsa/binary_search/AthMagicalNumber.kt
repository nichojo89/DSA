package com.nichols.dsa.binary_search

class AthMagicalNumber {
    fun solveSmallAgain(A: IntArray, B: Int): Int {
        val n = A.size
        var ans = n
        var sum = 0
        var start = 0

        for (end in A.indices) {
            sum += A[end]
            while (sum > B) {
                sum -= A[start]
                start++

                ans = Math.min(ans, end - start + 1)

                if (sum == 0)
                    break
            }
            if (sum == 0) {
                ans = 0
                break
            }
        }

        return ans
    }
    fun solve(A: Int, B: Int, C: Int): Int {
        val a: Long = A.toLong()
        val b: Long = B.toLong()
        val n: Long = C.toLong()
        val A = Math.min(a, b)
        val B = Math.max(a, b)
        val answer = getMagic(A, B, n)
        return answer.toInt()
    }
    fun gcd(a: Long, b: Long): Long {
        var a = a
        var b = b
        val temp = a + b
        a = if (a > b) a else b
        b = temp - a
        return if (a % b == 0L) {
            b
        } else gcd(b, a % b)
    }

//    fun getMagic(a: Long, b: Long, n: Long): Long {
//        var a = a
//        var b = b
//        var n = n
//        if (n * a <= b) {
//            return n * a
//        }
//        val g = gcd(a, b)
//        a /= g
//        b /= g
//        var filler: Long = 0
//        var sum: Long = 0
//        if (n > a + b - 1) {
//            sum = a + b - 1
//            filler = n / sum * a * b
//            n %= sum
//        }
//        if (n == 0L) {
//            return g * (filler - a)
//        }
//        val rat_a = n * b / (a + b)
//        val rat_b = n * a / (a + b)
//        return if (a * rat_a > b * rat_b) {
//            g * (Math.min(a * rat_a + a, b * rat_b + b) + filler)
//        } else {
//            g * (a * rat_a + a + filler)
//        }
//    }

    fun getMagic(a: Long, b: Long, n: Long): Long {
        var a = a
        var b = b
        var n = n
        if (n * a < b) {
            return n * a
        }
        if (n * a == b) {
            return a * (n + 1)
        }
        val g = gcd(a, b)
        a /= g
        b /= g
        var filler: Long = 0
        var sum: Long = 0
        if (n > a + b - 2) {
            sum = a + b - 2
            filler = n / sum * a * b
            n %= sum
        }
        if (n == 0L) {
            return g * (filler - a)
        }
        val rat_a = n * b / (a + b)
        val rat_b = n * a / (a + b)
        return if (a * rat_a > b * rat_b) {
            g * (Math.min(a * rat_a + a, b * rat_b + b) + filler)
        } else {
            g * (a * rat_a + a + filler)
        }
    }

    // if you do consider multiples of both a and b int the count;;;

}