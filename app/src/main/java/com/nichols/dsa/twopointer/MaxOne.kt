package com.nichols.dsa.twopointer

fun main(){
    val g = solvesss(intArrayOf(1,2,3,4,5),5)
}
fun solvesss(A: IntArray, B: Int): Int {
    val mod = 1000000007
    var ans = 0
    var left = 0
    var right = A.size-1
    val n = A.size

    while(left < n && right >= 0)
    {
        if(1*A[left]*A[right] >= B)
            right--
        else {
            ans = (ans % mod + (right+1)%mod)%mod
            left++
        }
    }

    return ans % mod
}

fun maxone(A: IntArray, B: Int): IntArray {
    var count = 0
    var l = 0
    var maxLength = 0
    var ans = intArrayOf()

    for(i in A.indices){
        if(A[i] == 0)
            count++

        while(count>B){
            if(A[l] == 0)
                count--
            l++
        }
        if(i-l+1> maxLength){
            maxLength = i-l+1
            ans = (l..i).toList().toIntArray()
        }
        maxLength = Math.max(maxLength,i-l+1)
    }
    return ans
}