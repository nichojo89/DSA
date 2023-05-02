package com.nichols.dsa.trie

fun main(){
    //ARRANGE
    val A = arrayOf("data", "circle", "cricket")
    val B = arrayOf("date", "circel", "crikket", "data", "circl")
    val searcher = BinarySearch()

    //ACT
    val ans1 = searcher.findMatches(A,B)

    //ASSERT
    val res1 = ans1 == "10100"

    //ARRANGE
    val C = arrayOf("hello", "world")
    val D = arrayOf("hella", "pello", "pella")

    //ACT
    val ans2 = searcher.findMatches(C,D)

    //ASSERT
    val res2 = ans2 == "110"

}
class BinarySearch {
    fun findMatches(A: Array<String>, B: Array<String>): String{
        val sb = StringBuilder()
        for( i in B.indices)
            if(findMatch(A,B[i]))
                sb.append('1')
            else
                sb.append('0')
        return sb.toString()
    }
    private fun findMatch(A: Array<String>, B: String) : Boolean {
        for(i in A.indices)
            if(isOneWayMod(A[i], B))
                return true
        return false
    }

    private fun isOneWayMod(A: String, B: String) : Boolean {
        //edge case
        if(A.length != B.length)
            return false
        var numDiffs = 0
        for(i in A.indices){
            if(A[i] != B[i]){
                numDiffs++
                if(numDiffs > 1)
                    return false
            }
        }
        return numDiffs == 1
    }
}