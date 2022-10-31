package com.nichols.dsa.collections

fun main(){
    //XORSumMin(6,12)
    //val three = DecimalToAnyBase(20,3)
    //val three = DecToBase(4,3)
    //BinaryToDecimalBase(22,3)
    val g = 0
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