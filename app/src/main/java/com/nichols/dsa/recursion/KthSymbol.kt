package com.nichols.dsa.recursion

fun main(){
//    val f = solveKthIndex(4,4)
//    val df = solveKthIndex(4,4)
    val A = 4
    val B = 4L
    val f = solveRecrusiveKthIndex(A,B,"0", 1.0)
    val g =  f[B.toInt()].digitToInt()
}

fun solveKthIndex(A: Int, B: Int): Int {
    var ans = "0"
    for(i in 1..A){
        var t = ""
        //replace chars
        if(ans[i-1] == '0')
            t += "01"
        else
            t += "10"
        if(ans.length >= B)
            return ans[B].digitToInt()

        ans = t
    }
    return ans[B].digitToInt()
}


fun solveRecrusiveKthIndex(A: Int, B: Long, C: String, D: Double): String{
    if(C.length > B)
        return C.toString()

    //How to populate array??
    val l = Math.pow(2.0,D)

    val f = (l-C.length).toInt()
    var c = C
    for(i in 0 until f){
        if(C[i] == '0')
            c += '1'
        else
            c += '0'

        if(c.length > B)
            return c
    }

    return solveRecrusiveKthIndex(A,B,c,D+1)
}
//0, i = 0, c = 1
//01, i = 1, c = 2
//0110, i = 2, c = 4
//01101001, i = 3, c = 8
//0110100110010110, i = 4, c = 16
//01101001100101101001011001101001, i = 5, c = 32