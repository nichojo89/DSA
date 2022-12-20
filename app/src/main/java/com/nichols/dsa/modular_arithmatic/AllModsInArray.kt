package com.nichols.dsa.modular_arithmatic

fun main(){
    val ans = solveModSum(intArrayOf(686, 675, 758, 659, 377, 965, 430, 220, 599, 699 ))
    //28759
}
fun solvsdfsdfe(A: IntArray): Int {
    val mod = (1e9 + 7)
    val max = A.maxOf { it }
    val count = IntArray(max+1)
    var ans = 0


    //create frequency array
    for(i in A.indices)
        ++count[A[i]]

    for(i in 1 until max)
        for(j in 1 until max){
            val x = i % j
            val t = count[i] * count[j] * x
            ans = (((ans % mod) + (t % mod)) % mod).toInt()
        }

    return ans
}