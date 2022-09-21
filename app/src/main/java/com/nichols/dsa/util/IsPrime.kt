package com.nichols.dsa.util


fun main() {
    val a = isPrime(123L)
}

fun isPrime(A: Long): Int {
    //if less than or equal to 1 or is multiple of 2 then not prime
    if(A <= 1)
        return 0
    //2 is prime because it has ony 2 factors
    else if(A == 2L)
        return 1
    else if(A % 2 == 0L)
        return 0

    var i = 3
    while(i <= Math.sqrt(A.toDouble())){

        if(A % i == 0L)
            return 0
        //only check the odds
        i += 2
    }
    return 1
}