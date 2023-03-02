package com.nichols.dsa.queues

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import java.util.function.Function

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    var f = MaxFreqStack();
    f.solve(arrayListOf(
        arrayListOf(1, 8),
        arrayListOf(1, 6),
        arrayListOf(2, 0),
        arrayListOf(2, 0),
        arrayListOf(1, 7),

    ))
}