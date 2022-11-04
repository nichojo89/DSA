package com.nichols.dsa.collections

fun main(){
    //XORSumMin(6,12)
    //val three = DecimalToAnyBase(20,3)
    //val three = DecToBase(4,3)
    //BinaryToDecimalBase(22,3)
//    val g = 0
//    solveAlexHelpsSam(7)
//    solveAlexHelpsSam(4)
    //both should be 2
    //val thirty = solveMagicNumber(3)
//    val sixFifty = solveMagicNumber(10)
//    val g = 0
//    val a = solveConcatSort(28,97,32)
    solveLeapYear(1999)
}

/**
 * The year is multiple of 400.
 * or the year is multiple of 4 and not multiple of 100.
 */
fun solveLeapYear(A: Int): Int = if(A % 400 == 0 || (A % 4 == 0 && A % 100 != 0)) 1 else 0

fun solvzzze(A: IntArray): Int {
    A.sort()

    if(A[A.size-1] == 0)
        return 1
    for(i in 0 until A.size-1){
        if(A[i] != A[i+1]){
            if(A[i] == A.size-i -1)
                return 1
        }
    }
    return -1
}
fun solveNobileIntGreaterThan(A: IntArray): Int {
    A.sort()
    var less = 0
    var count = 0
    //Change this to check last element for 0
    //As the array is sorted 0 is the only option for the last element
    if(A[A.size-1] == 0)
        return -1

    for(i in 1 until A.size){
        if(A[i] != A[i-1]){
            less = i
            //NEW
            if(A[i] == A.size-i-1)
                return 1
        }
        //Remove the less strategy
//        if(A[i] == less)
//            return 1
    }
    return -1
}

fun solvsse(A: IntArray): Int {
    A.sort()
    var smaller = 0
    var ans = 0
    if(A[0] == 0)
        ans++

    for(i in 1 until A.size) {
        if(A[i] != A[i-1])
            smaller = i
        if(A[i] == smaller)
            ans ++
    }
    return ans
}

fun solvesd(A: String): Int {
    val lastThree = A.takeLast(3).toInt()
    if(lastThree % 8 == 0)
        return 1
    else
        return 0
}

fun solveConcatSort(A: Int, B: Int, C: Int): Int {
    var ans = if(A < B){
        if(A < C){
            if(B < C){
                "$A$B$C"
            } else {
                "$A$C$B"
            }
        } else {
            "$C$A$B"
        }
    } else if(B < C){
        //B is first
        if(A < C) "$B$A$C" else "$B$C$A"
    } else  {
        "$C$B$A"
    }
    return ans.toInt()
}

/**
 * First few magic numbers are 5, 25, 30, 125, 130,
 * Get the largest magic number <= A
 */
fun solveMagicNumber(A: Int): Int {
    var a = A
    var x = 1
    var magic = 0
    while(a >0){
        x *= 5
        if(a and 1 == 1)
            magic += x
        //5 (5^1)

        //25 (5^2)
        //30 (5^1 + 5^2)

        //125 (5^3)
        //130 (5^1 + 5^3)
        //150 (5^2 + 5^3)
        //155 (5^1 + 5^2 + 5^3)

        //625 (5^4)
        //630 (5^1 + 5^4)
        //650 (5^2 + 5^4)

    }

    return magic
}
fun solveAlexHelpsSam(A: Int): Int {
    if(A <= 0)
        return 0

    var a = A
    var helpRequests = 1
    var total = 1
    var i = 0
    var cont = true
    while(total < A){
        if(total shl i < A)
            total *= 2
        else {
            total += 1
            helpRequests += 1
        }

        i++
    }
    val r = A - total

    return helpRequests + r
}

/**
 * Brute force
 */
fun XORSum(A: Int, B: Int): Int{
    val max = maxOf(A,B)
    var result = Integer.MAX_VALUE
    for(i in 0..max){
        val a = (i xor A) + (i xor B)
        if(a < result)
            result = a
    }

    return result
}

fun BinaryToDecimalBase(A: Int, B: Int): Int{
    //get powers
    val powers = arrayListOf<Int>()
    var i = 0.0

    var highestBase = 0
    while(highestBase < A){
        highestBase = Math.pow(B.toDouble(),i).toInt()

        //this is repeated code
        if(highestBase < A)
            powers.add(highestBase)
        i++
    }

    var result = 0
    val binaryString = A.toString().toCharArray()
    var ii = 0
    for(b in binaryString.indices.reversed()){
        val binary = binaryString[b].toString().toInt()
        result += binary * powers[ii]
        ii++
    }
    return result
}
fun DecimalToAnyBase(A: Int, B: Int): Int {
    val powers = arrayListOf<Int>()
    var i = 0.0

    //Calculate applicable powers
    var highestBase = 0
    while(highestBase <= A){
        highestBase = Math.pow(B.toDouble(),i).toInt()
        //TODO there's probably a better way to do this loop and avoid repeating
        if(highestBase <= A)
            powers.add(highestBase)
        i++
    }
    //Create binary string of base B
    var remainder = A
    var num = ""
    for(j in powers.indices.reversed()){
        val pow = powers[j]
        val baseNumber = remainder / pow
        if(baseNumber > 0){
            num += baseNumber

            remainder -= baseNumber * powers[j]
        } else {
            num += "0"
        }
    }

    if(powers.size == 0 && A == 1)
        return A
    return num.toInt()
}