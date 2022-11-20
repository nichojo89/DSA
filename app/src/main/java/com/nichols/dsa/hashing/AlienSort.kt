package com.nichols.dsa.hashing

fun main() {
//    val A = arrayOf("hello", "scaler", "interviewbit")
//    val B = "adhbcfegskjlponmirqtxwuvzy"
    val A = arrayOf("fine", "none", "no")
    val B = "qwertyuiopasdfghjklzxcvbnm"
    val C = solveAlienSortTwo(A,B)
//    val ans  = solveJosephus(100)
}
fun solveAlienSortTwo(A: Array<String>, B: String): Int{
    val hm = hashMapOf<Char,Int>()
    for(i in B.indices)
        hm[B[i]] = i

    val l = A.maxOf { it.length }
    for(k in 0 until l)
        for(i in 0 until A.size-1)
            if(!compareAlien(A[i], A[i+1], k, hm))
                return 0

    return 1
}
fun compareAlien(A: String, B: String, C: Int, D: HashMap<Char,Int>) : Boolean{
    if(A.length <= C || B.length <= C){
        //so far everythings atleast been in order
        val a = A.substring(0,C)
        val b = B.substring(0,C)
        if(a == b
            && B.length <= C){
            return false
        }
        //no then none
    } else {
        val g = A[C]
        val a = D[A[C]]!!
        val b = D[B[C]]!!
        return a <= b
    }
    return true
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