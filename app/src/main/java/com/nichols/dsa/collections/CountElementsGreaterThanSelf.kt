package com.nichols.dsa.collections

import java.util.*

fun main(){
//    val arr = intArrayOf(13, 7, 16, 18, 14, 17, 18, 8, 10)
//    val count = solve(arr)
//    println(count)
    val a = intArrayOf(6, 3, 3, 6)
    val b: Array<IntArray> = arrayOf(
        intArrayOf(1,4),
        intArrayOf(1,3)
    )
    solvea(a,b)
}

fun solvea(A: IntArray, B: Array<IntArray>): IntArray {
    val arr = arrayListOf<Int>()
    for(a in B){
        val c = A.copyOfRange(a[0]-1, a[1])
        arr.add(c.sum())
    }
    return arr.toIntArray()
}

fun findNumInSlidingWindow(A: IntArray): Int {
    //count of seconds
    var count = 0
    var max = Integer.MIN_VALUE
    //get max
    for(num in A){
        if(num > max)
            max = num
    }
    for(num in A){
        if(num != max){
            val d = Math.abs(max - num)
            count += d
        }
    }
    return count
}


fun reverse(B: IntArray): IntArray {
    val A = B
    var i = 0
    var j = A.size-1
    while(i < j){
        var t = A[i]
        A[i] = A[j]
        A[j] = t
        i++
        j--
    }

    return A
}

//fun solve(A: IntArray, B: Int): Int {
//    var count = 0
//    if(B == null)
//        return 1
//    for(i in 0..A.size){
//        for(j in i+1 until A.size){
//            println("$i, $j")
//            if(A[i].toLong() + A[j].toLong() == B.toLong() ){
//                //println("${A[i]}, ${A[j]}")
//                count++
//            }
//        }
//    }
//
//    return count
//}


fun findNumInSlidingWindow(A: IntArray, B: Int): Int {
    var count = 0
    for (i in 0 until A.size - 1) {
        for (j in i + 1 until A.size) {
            if (A[i] + A[j] == B) {
                count++
            }
        }
    }

    return count
}

fun solveb(A: IntArray, B: Int): Int {
    var count = 0L

    // sort the array in ascending order
    Arrays.sort(A);

    // maintain two indices pointing to endpoints of the array
    var low = 0;
    var high = A.size - 1;

    while (low < high) {
        if (A[low] + A[high] == B)
            count++

        if (A[low] + A[high] < B) {
            low++;
        }
        else {
            high--;
        }
    }
    val f = Symptom(true,"desc", sneezes = 12)
    val fss =  f.copy(cold = false)

    return count.toInt()
}

open class MyBase{
    public var name: String = "Jon"
}
open class MyJon: MyBase(){
    fun test() {
        name = "Jonathan"
    }
}
data class Symptom(val cold: Boolean, val desc : String, val sneezes: Int )

//Base class must be open
//inherit class must have ()
//data class has copy()