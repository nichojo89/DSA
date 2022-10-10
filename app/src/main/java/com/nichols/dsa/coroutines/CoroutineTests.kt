package com.nichols.dsa.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    doWorld()
    noBigDeal()
}

suspend fun noBigDeal() = coroutineScope{
    repeat(100_000){
        launch{
            delay(5000L)
            println(".")
        }
    }
}

suspend fun doWorld() = coroutineScope {
    val job = launch {
        println("World")
    }
    println("Hello")
    job.join()
    println("Done")
}