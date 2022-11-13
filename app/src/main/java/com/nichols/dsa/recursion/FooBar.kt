package com.nichols.dsa.recursion

fun main(){
    val g = foo(3,5)
    val f = 0
}
fun bar(x: Int, y: Int): Int {
    if(y==0) return 0

    return (x + bar(x, y-1))
}
fun foo(x: Int, y: Int): Int{
    if(y == 0)
        return 1

    return bar(x, foo(x,y-1))
}
