package com.nichols.dsa.prime

fun main(){
    val a = solveFactArr(intArrayOf(2, 3, 2, 3))
}
fun solveFactArr(A: IntArray): Int {
    A.sort()
    val m = A.last()

    //create sieve
    val primes = BooleanArray(m+1){true}
    primes[0] = false
    primes[1] = false
    var p=2

    while(p*p <=m){
        if(primes[p]){
            //set multiples
            var i = p*p
            while(i<=m){
                primes[i] = false
                i += p
            }
        }
        p++
    }
    //count values <= i
    var count = 0
    for(i in A){

    }
    return  0
}