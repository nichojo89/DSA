package com.nichols.dsa.sorting

fun solveLargestNumberTwo(A: IntArray) : String {
    var isAllZeros = true
    A.sortedWith(NumericStringComparator())
    //convert array to largest number
    var ans = ""
    for(s in A){
        if(s != 0){
            isAllZeros = false
        }
        ans += s.toString()
    }


    return if(isAllZeros) "0" else ans
    return ans
}
class NumericStringComparator: Comparator<Int>{
    override fun compare(o1: Int?, o2: Int?): Int {
        val a = "$o1$o2".toLong()
        val b = "$02$o1".toLong()

        return if(b >= a) 1 else 0
    }

}
fun solveLargestNumber(A: IntArray) : String {
    var result = ""
    var str = arrayListOf<String>()
    for(i in A.indices){
        str.add(A[i].toString())
    }
    //TODO convert to bubble sort
    str.sort()
    for(i in str.indices){
        result += str[i]
    }
    var pos = 0
    while(result[pos] == '0' && pos + 1 < result.length){
        pos++
    }
    return result.substring(pos)
}
fun largestNumber(A: IntArray): String {
    //this is actually better than using sum because sum could be to large
    //Checks if all values are zero
    var isAllZeros = true

    //bublesort array
    for (i in 0 until (A.size - 1))
        for (j in 0 until (A.size - i - 1))
            if(comparator(A[j],A[j+1]))
                swap(j, A)
    //convert array to largest number
    var ans = ""
    for(s in A){
        if(s != 0){
            isAllZeros = false
        }
        ans += s.toString()
    }


    return if(isAllZeros) "0" else ans
}

/**
 * Compares concantenated integers
 */
fun comparator(A: Int, B: Int): Boolean{
    val a = "$A$B".toLong()
    val b = "$B$A".toLong()

    return if(b >= a) true else false
}

/**
 * Swaps two elements in an array
 */
fun swap(a: Int, c: IntArray){
    val b = a+1
    val d = c[a]
    c[a] = c[b]
    c[b] = d
}