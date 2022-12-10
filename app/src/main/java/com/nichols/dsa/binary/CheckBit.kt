package com.nichols.dsa.binary

fun numSetBits(A: Int): Int {
    var A = A
    var ones = 0
    while (A != 0) {
        A = A and A - 1
        ones++
    }
    return ones
}

fun singleNumbera(A: IntArray): Int {
    var ans = 0.0
    //for each bit
    for(i in 0 until 32){
        var count = 0
        for(j in A.indices)
            if(checkBit(A[j],i))
                count++

        //is there more than the 3 occurances?
        if(count % 3 == 1){
            ans = ans + Math.pow(2.0,i.toDouble())
            ans = (ans.toInt() or (1 shl i)).toDouble()
        }
    }
    return ans.toInt()
}

fun checkBit(A: Int, B: Int): Boolean {
    return ((A shr B) and 1) > 0
}