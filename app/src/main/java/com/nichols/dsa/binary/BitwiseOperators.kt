package com.nichols.dsa.binary

fun main(){
//val ans1 = solveSetIfUnset(4,1)
//val ans2 = solveSetIfUnset(5,2)
//    val t = solveCheckIfSet(8,4)
//    val f = solveCheckIfSet(8,3)
//    val f2 = solveCheckIfSet(5,5)
//    val twentyFour = solveUnsetFromRight(25,3)
//    val thirtyTwo = solveUnsetFromRight(37,3)
    reverse(3u)
    //3221225472

    val g = 0
}
fun reverse(a: UInt): UInt {
    var b = a
    val sizeOfInt = 32
    var reverse = 0u
    for (position in sizeOfInt - 1 downTo 1) {
        reverse += b and 1u shl position
        b = b shr 1
    }
    return reverse
}

fun solvse(A: IntArray): Int {
    var s = ""
    for(n in A){
        s += n.toString()
    }
    return if(s.toInt() % 3 == 0)
        1
    else
        0
}

fun checkBit(A: UInt, B: Int): Int =  if(A and  (1u shl B) == (1u shl B))  1  else  0
fun setBit(A: UInt, B: Int): UInt {
    val a = 1u shl A.toInt()
    val b = 1u shl B
    return a or b
}

/**
 * You are given two integers A and B.
 * If B-th bit in A is set, make it unset
 * If B-th bit in A is unset, leave it as it is
 * Return the updated A value
 */
fun solveSetIfUnset(A: Int, B: Int): Int {
    //val binaryForB = (1 shl B)
    //check bit
    //using and
    // if(A and binaryForB == binaryForB)
    //using or
    //if(A or binaryForB == A)
    //using xor
    //if(A xor binaryForB < A)
    //shift right
    if((A shr B) and 1 == 1)
        return A xor (1 shl B)
    else
        return A
}

/**
 * Given an integer A. Unset B bits from the right of A in binary.
 * For eg:-
 * A = 93, B = 4
 * A in binary = 1011101
 * A should become = 1010000 = 80. Therefore return 80.
 */
fun solveUnsetFromRight(A: Long, B: Int): Long {
    var a = A
    for(b in 0..B){
        val f = unsetBit(a,b)
        a = f
    }

    return a
}
fun unsetBit(A: Long, B: Int): Long {
    if((A shr B) and 1 == 1L)
        return A xor (1L shl B)
    else
        return A
}
fun solveCreateBit(A: Int, B: Int): Int {
    val a = 1 shl A
    val b = 1 shl B
    return a or b
}
fun solveCheckIfSet(A: Int, B: Int): Int =
    if(A and (1 shl B) == (1 shl B)) 1 else 0