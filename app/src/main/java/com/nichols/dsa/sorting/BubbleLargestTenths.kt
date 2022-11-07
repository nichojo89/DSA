package com.nichols.dsa.sorting

fun main(){
    val g = Solution().solvsse(intArrayOf(36, 63, 63, 26, 87, 28, 77, 93, 7))
    //expected: 7 28 26 36 63 63 77 87 93
    val gg = 0

}
fun to_lower(A: CharArray): CharArray {
    for(i in A.indices){
        if(A[i] >= 65.toChar() && A[i] <= 90.toChar()){
            A[i] = A[i] + 32
        }
    }
    return A
}

fun solve(A: String): String {
    var ans = ""
    for(i in A.indices){
        ans += A[i].toInt() xor 32
        // //is capital?
        // if(A[i] >= 65.toChar() && A[i] <= 90.toChar()){
        //     ans += A[i] + 32
        // } else  {
        //     ans += A[i] - 32
        // }
    }
    return ans
}
fun solveasdasd(A: String): String {
    var ans = ""
    for(i in A.indices){
        //is capital?
        if(A[i] >= 65.toChar() && A[i] <= 90.toChar()){
            ans += A[i] + 32
        } else  {
            ans += A[i] - 32
        }
    }
    return A
}
class Solution {
    fun solvsse(A: IntArray): IntArray {
        val a = A.sortedWith(object: Comparator<Int?> {
            override fun compare(o1: Int?, o2: Int?): Int {
                val tens_digit1: Int = (o1!! / 10) % 10
                val tens_digit2: Int = (o2!! / 10) % 10
                return if (tens_digit1 === tens_digit2) {
                    o2!! - o1!!
                } else tens_digit1 - tens_digit2
            }

        }).sorted().toIntArray()
        return a
    }
    fun solve(A: IntArray): IntArray {
        //bubble sort
        for(i in 0 until (A.size-1))
            for(j in 0 until (A.size-i-1))
                if(tenComporater(j,A)){
                    //swap
                    val tmp = A[j]
                    A[j] = A[j + 1]
                    A[j + 1] = tmp
                }
        return A
    }
    fun solveasdasd(A: IntArray): IntArray {
        val a = A.sortedWith(object: Comparator<Int?> {
            override fun compare(o1: Int?, o2: Int?): Int {
                val aTens = o1!! / 10 % 10
                val bTens = o2!! / 10 % 10
                return if(aTens === bTens) o2 - o1 else aTens - bTens
            }

        }).sorted().toIntArray()
        return a
    }

    fun tenComporater(A: Int, B: IntArray): Boolean {
        val a = "${B[A]}"
        val b = "${B[A+1]}"


        val c = if(a.length > 1) a[a.length-2].toString().toInt() else 0
        val d = if(b.length > 1) b[b.length-2].toString().toInt() else 0
        //#'s are same and the max is not currently in first position
        if(((c == d && Math.max(a.toInt(),b.toInt()) == b.toInt()) || d > c) && d+c != 0)
            return true
        else
            return false
    }


}
