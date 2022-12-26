package com.nichols.dsa.prime

fun main(){
    val ans = solvePrimeSeive(3)
}


fun solvePrimeSeive(A: Int): IntArray {
    val primes = BooleanArray(A+1){true}
    //edge case
    primes[0] = false
    primes[1] = false

    //mark all the primes
    var p = 2
    while(p*p <= A){
        if(primes[p]){
            var i = p*p
            while(i <= A){
                primes[i] = false
                i += p
            }
        }
        p++
    }
    //add primes to array
    val ans = arrayListOf<Int>()
    for(i in 2..A)
        if(primes[i])
            ans.add(i)

    return ans.toIntArray()
}