package com.nichols.dsa

import com.nichols.dsa.arrays.Interval
import com.nichols.dsa.arrays.MergeIntervals

fun main(){
//    val g = FirstMissingAbsolute()
//    val ans = g.firstMissingPositive(intArrayOf( 2, 3, 1, 2 ))
    val k = MergeIntervals()
//    val j = arrayListOf<Interval>()
//    j.add(Interval(1,3))
//    j.add(Interval(6,9))
    val j = arrayListOf<Interval>()
    j.add(Interval(4, 7))
    j.add(Interval(5, 6))
    j.add(Interval(6, 6))
    j.add(Interval(1, 10))
    j.add(Interval(2, 9))
    j.add(Interval(3, 8))

    //(), (), (), (), (), ()
    val ans = k.mergeIntervals(j);
//[1,6],[8,10],[15,18]
}