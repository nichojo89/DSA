package com.nichols.dsa.util


fun main() {
    val A = 10

    var primeCount = 0
    for(i in 1..A){
        if(isPrime(i.toLong()) && i != A){
            primeCount++
        }
    }
    var f =  primeCount
}

fun isPrime(A: Long): Boolean {
    //if less than or equal to 1
    if(A <= 1)
        return false
    //2 is prime because it has ony 2 factors
    else if(A == 2L)
        return true
    //if num is a multiple of 2 then not prime
    else if(A % 2 == 0L)
        return false


    var i = 3
    while(i <= Math.sqrt(A.toDouble())){

        if(A % i == 0L)
            return false
        //only check the odds
        i += 2
    }
    return true
}

