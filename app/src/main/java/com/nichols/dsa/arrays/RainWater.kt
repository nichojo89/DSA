package com.nichols.dsa.arrays

fun main(){
    val ans = trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
}



// public int solve(int A) {
//         int ans = 0;
//         for (int i = 1;
//                 i <= A; i *= 10)
//         {
//             int divider = i * 10;
//             countr += (A / divider) * i +
//                     Math.min(Math.max(A %
//                             divider - i +
//                                 1, 0), i);
//         }
//         return ans;
//     }



fun solveasd(A: Int): Int {
    var ans = 0
    for(i in 1..A step {it * 10}){
        val divider = i * 10
        ans += (A/divider)* i +
                Math.min(
                    Math.max(A % divider - i + 1,0)
                    ,i)
    }
    return ans
}

// for increasing rangeTo (..)
infix fun IntRange.step(next: (Int) -> Int) =
    generateSequence(first, next).takeWhile { if (first < last) it <= last else it >= last }

// for decreasing downTo
infix fun IntProgression.step(next: (Int) -> Int) = (first..last).step(next)
fun trap(A: IntArray): Int {
    val lMax = IntArray(A.size)
    lMax[0] = A.first()
    for(i in 1 until A.size){
        lMax[i] = Math.max(lMax[i-1],A[i]);
    }

    val rMax = IntArray(A.size)
    rMax[rMax.size-1] = A.last()
    for(i in A.size-2 downTo 0 ){
        rMax[i] = Math.max(rMax[i+1],A[i])
    }

    var ans = 0
    val mMin = IntArray(A.size)
    for(i in mMin.indices){
        mMin[i] = Math.min(lMax[i], rMax[i])
        ans += (mMin[i] - A[i])
    }
    return ans
}