package com.nichols.dsa.util

fun main() {
    val num = isPerfectNumber(28)
}

fun isPerfectNumber(num: Int){
    val factors = mutableListOf<Int>()
    if(num > 1){
        (1..num / 2)
            .filter { n -> num % n == 0 }
            .forEach { n -> factors.add(n) }
        val f = if(factors.sum() == num) 1 else 0
    } else {
        //not perfect
    }
}
