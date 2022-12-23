package com.nichols.dsa.prime

fun primesum(A: Int): IntArray {
    //create Seive array
    val primes = BooleanArray(A+1){true}

    primes[0]
    primes[1]
    var p=2
    while(p*p <=A){
        if(primes[p]){
            //set all multiples of factor p as false
            var i = p*p
            while(i <= A){
                primes[i] = false
                i += p
            }
        }
        p++
    }
    //2 is our first prime
    for(i in 2..A){
        if(primes[i] && primes[A-i]){
            return intArrayOf(i,A-i)
        }
    }
    return intArrayOf(0)
}