package com.nichols.dsa.prime

fun main(){
//    val t = countFactors(25)
//    val w = sieve(11)
    val s = spf(50)
}

//O(n log(log n))
fun spf(A:Int): IntArray {
    val spf = IntArray(A+1){it}
    //we can iterate to √n instead of n
    val n = Math.sqrt(A.toDouble()).toInt()
    for(i in 2 ..n)
        if(spf[i] == i){
            //prime #, set its multiples as this spf value
            var j = i*i
            while(j <= A){
                //If value was never updated before
                if(spf[j] == j)
                    spf[j] = i
                j += i
            }
        }

    return spf
}

//O(n log(log(n)))
fun sieve(A: Int) : BooleanArray {
    val s = BooleanArray(A+1){true}
    s[0] = false
    s[1] = false
    //we can iterate to √n instead of n
    val n = Math.sqrt(A.toDouble()).toInt()
    for(i in 2..n){
        if(s[i]){
            //set i's multiples as false
            //start with i*i
            var j = i*i
            while(j <= A){
                s[j] = false
                j += i
            }
        }
    }
    return s
}



//O(√n)
fun checkPrime(A: Int): Boolean {
    val f = countFactors(A)
    return f==2
}
//O(√n)
fun countFactors(A: Int) : Int {
    var count = 0
    val n = Math.sqrt(A.toDouble()).toInt()
    for(i in 1  ..  n)
        if(A%i==0)
            if(i==(A/i))
                count++
            else
                count+=2

    return count
}

fun solve(A: IntArray): IntArray {
    for(i in A.indices){
        A[i] = countFactors(A[i])
    }
    return A
}