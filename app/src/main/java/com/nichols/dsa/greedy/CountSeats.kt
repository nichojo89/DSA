package com.nichols.dsa.greedy

import com.nichols.dsa.prime.power


fun seats(A: String): Int {
    val personPositions = arrayListOf<Int>()
    var count = 0
    var len  = A.length;
    for(i in A.indices){
        if(A[i] == 'x')
        {
            personPositions.add(i-count)
            count++
        }
    }

    if(count == len || count == 0)
        return 0


    val mediumIndex = (count-1)/2
    val mediumValue = personPositions.get(mediumIndex)
    var ans = 0
    val mod = 1e9.toInt() + 7
    for(i in personPositions.indices){
        ans = (ans%mod+
                Math.abs(personPositions.get(i) -
                mediumValue) % mod) % mod
    }

    return ans % mod
}