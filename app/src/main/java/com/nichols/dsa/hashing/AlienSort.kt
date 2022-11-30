package com.nichols.dsa.hashing

fun main() {
//    val A = arrayOf("hello", "scaler", "interviewbit")
//    val B = "adhbcfegskjlponmirqtxwuvzy"
    val A = arrayOf("ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow")
    val B = "nbpfhmirzqxsjwdoveuacykltg"
    val C = solveAlienSortTwo(A,B)
//    val ans  = solveJosephus(100)
}
fun solveAlienSortTwo(A: Array<String>, B: String): Int{
    val hm = hashMapOf<Char,Int>()
    for(i in B.indices)
        hm[B[i]] = i

    //For each word
    for(i in 0 .. A.size-2)
    //Compare word with the next word
        if(!compareAlien(A[i], A[i+1], hm))
            return 0

    return 1
}
fun compareAlien(word: String, nextWord: String, hm: HashMap<Char,Int>) : Boolean{
    val l = maxOf(word.length, nextWord.length)

    val fOne = hm[word[0]]!!
    val fTwo = hm[nextWord[0]]!!

    if(fOne > fTwo)
        return false
    else if (fOne == fTwo){
        for(i in 0 until l){
            if(i < word.length && i < nextWord.length){
                //check if characters are in order
                val g = word[i].digitToInt()
                val gg = nextWord[i]!!
                val a = hm[word[i]]!!
                val b = hm[nextWord[i]]!!
                if(a > b)
                    return false
            } else {
                //one string is not long enough
                val c = word.substring(0,i)
                val d = nextWord.substring(0,i)
                //were they the same up until this index,
                // if so the shortest word should come first
                if(c == d && word.length > nextWord.length)
                    return false
            }
        }
    } else {
        return true
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