package com.nichols.dsa

fun main(){
    val a = intArrayOf(683, 354, 95, 937, 78, 246, 319, 516, 913, 112 )
    //913
    //val f = factorial(4)
    val ans = solve(a)
}

private var max = 0

fun solve(A: IntArray): Int {
    return setMaxModulo(A,0)
}

//Recursive method to search pairs
fun setMaxModulo(a: IntArray, index: Int): Int {
    a.forEachIndexed{ i, num ->
        if(i != index){
            val left = a[index]

            //zero check only required for this specific method
            if(left != 0
                && num != 0
                && left % num > max){
                max = left % num
            }
        }
    }
    if(index < a.size -1){
        setMaxModulo(a,index + 1)
    }
    return max
}


fun factorial(n: Int): Long{
    return if(n >= 1)
        n * factorial(n-1)
    else
        n.toLong()
}