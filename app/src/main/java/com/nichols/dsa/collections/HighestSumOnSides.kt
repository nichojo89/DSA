package com.nichols.dsa.collections

import android.os.Build
//import androidx.annotation.RequiresApi
import java.lang.Exception
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val a = intArrayOf(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35)

    val c = solved(a,48)
}

fun solved(A: IntArray, B: Int): Int{
    val n = A.size
    var cur = 0.0
    var ans = Math.pow(-10.0,9.0)

    for(i in 0 until B){
        cur += A[i]
        if(i == B-1){
            val g = 0
        }

    }

    var back = B-1
    ans = Math.max(ans,cur)


    val test = n-B
    try {
        for(j in A.size-1 downTo n-B){
            //
            cur += A[j]
            cur -= A[back]
            back--
            ans = Math.max(ans,cur)
        }
    } catch (e: Exception){
        val f = 0
    }

    //expected 6253
    return ans.toInt()
}