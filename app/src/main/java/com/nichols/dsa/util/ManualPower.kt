package com.nichols.dsa.util

fun main() {
    val r = ManualPower(4,5)
    //1024
}
fun ManualPower(A: Int, B: Int) {
    var result = A
    for(i in 2..B){
        result = result * A
    }
}