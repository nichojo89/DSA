package com.nichols.dsa.sorting

//fun main(){
//    //val ans = freeze().largestNumber(intArrayOf( 9, 99, 999, 9999, 9998))
//    val g = 0
//}
//
//class freeze {
//    fun bubbleSortTens(A: IntArray) : IntArray {
//        for (i in 0 until (A.size - 1)) {
//            for (j in 0 until (A.size - i - 1)) {
//                // This is a single step
//                if (A[j] > A[j + 1]) {
//                    val tmp = A[j]
//                    A[j] = A[j + 1]
//                    A[j + 1] = tmp
//                }
//            }
//        }
//    }
//    fun largestNumberThree(A: IntArray): String {
//        A.sortedWith(object  : Comparator<Int> {
//            override fun compare(o1: Int?, o2: Int?): Int {
//                val a = "$o1$o2"
//                val b = "$o2$o1"
//
//                return if(a > b) -1 else if (a == b) 0 else 1
//            }
//        })
////    var sortedListOfperson = listofperson
////        .sortedWith <Person> (object : Comparator <Person> {
////            override fun compare (p0: Person, pi: Person) : Int {
////                if (p0.age > pl.age) {
////                    return 1
////                }
////                if (p0.age = pl.age) {
////                    return 0
////                }
////                return -1
////            }
////        })
//
//
//
//    fun sortColors(A: ArrayList<Int>): ArrayList<Int>? {
//        var zero = 0
//        var two: Int = A.size - 1
//        var i = 0
//        while (i <= two) {
//            if (A[i] === 0) {
//                val temp = A[zero]
//                A[zero] = 0
//                A[i] = temp
//                zero++
//                i++
//            } else if (A[i] === 2) {
//                val temp = A[two]
//                A[two] = 2
//                A[i] = temp
//                two--
//            } else {
//                i++
//            }
//        }
//        return A
//    }
//
//
//    fun largestNumber(A: IntArray): String {
//        //bublesort array
//        for(i in 0 until A.size-1)
//            for(j in 0..A.size-2)
//                if(comparator(A[j],A[j+1]))
//                    swap(j, A)
//        var ans = ""
//        for(s in A)
//            ans += s.toString()
//
//        return if(ans.toLong() == 0L) "0" else ans
//    }
//
//    fun comparator(A: Int, B: Int): Boolean{
//        val a = "$A$B".toInt()
//        val b = "$B$A".toInt()
//
//        return if(b >= a) true else false
//    }
//
//    /**
//     * Swaps two elements in an array
//     */
//    fun swap(a: Int, c: IntArray){
//        val b = a+1
//        val d = c[a]
//        c[a] = c[b]
//        c[b] = d
//    }
//}