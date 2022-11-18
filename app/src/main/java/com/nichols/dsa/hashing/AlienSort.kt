package com.nichols.dsa.hashing

fun main() {
//    val A = arrayOf("hello", "scaler", "interviewbit")
//    val B = "adhbcfegskjlponmirqtxwuvzy"
//    val C = solveAlienSort(A,B)
    val ans  = solveJosephus(100)
}

fun solveJosephus(A: Int): Int {
    //find highest power of 2
    var j = 1
    var cont = true
    while (cont){
        if((j * 2) > A){
            cont = false
        } else {
            j *= 2
        }
    }
    val kills = A - j
    var winner = 1
    for(k in 0 until kills){
        winner += 2
    }
    return winner
}
fun solveAlienSort(A: Array<String>, B: String): Int {
    val l = A.maxOf { it.length }
    //for the length of the longest word
    for(i in 0..l){
        //iterate through each word
        var isSame = true
        for(k in 0..A.size-2){
            val aa = A[k]
            val bb = A[k+1]

            if(isSame && aa.length > bb.length)
                return 0

            val r = comparator(A[k][i],A[k+1][i],B)
            if(r > 0 )
                return 0
            if(r < 0)
                isSame = false
        }
    }
    return 1
}

fun comparator(A: Char, B: Char, C: String) : Int {
    val a = C.indexOf(A)
    val b = C.indexOf(B)

    if(a < b)
        return 1
    else if (a == b)
        return 0
    else
        return -1
}