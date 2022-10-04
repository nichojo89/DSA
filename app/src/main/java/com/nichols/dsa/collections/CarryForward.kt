package com.nichols.dsa.collections

fun main() {
    val a = intArrayOf(1,7,3,7,4,8,21,4,8,1,6,1,8)
    val f = CarryForward()
    val b = f.solveClosestMinMaxSubset(a)
}

class CarryForward{

    /**
     * Find closest min and max subset in array
     */
    fun solveClosestMinMaxSubset(A: IntArray): Int {
        var l = A.size
        val max = A.maxOrNull()!!
        val min = A.minOrNull()!!

        if(max == min)
            return 1
        for(i in A.indices){
            if(A[i] == min){
                for(j in i+1 until A.size){
                    if(A[j] == max){
                        //if j-i+1 is greater than current l than replace current l
                        l = Math.min(l,j-i+1)
                        break
                    }
                }
            } else if (A[i] == max){
                for(j in i+1 until A.size){
                    if(A[j] == min){
                        l = Math.min(l, j-i+1)
                        break
                    }
                }
            }
        }

        return l
    }

    /**
     * You are given an integer array A.
     * Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
     * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
     */
    fun solveHasEvenSubArrays(A: IntArray): String {
        //get factors of the size of array
        val factors = (1..A.size/2).filter { A.size % it == 0 } + A.size

        for(f in factors){
            var match = false
            for(j in 0 until A.size-1 step f){
                if(f % 2 == 0){
                    val x = A[j]
                    val y = if(f == 1) A[j+1] else A[j+f-1]
                    if(x % 2 == 0 && y % 2 == 0)
                        match = true
                    else{
                        match = false
                        break
                    }
                }
            }
            if(match)
                return "YES"
        }
        return "NO"
    }

    fun maxProfit(A: IntArray): Int {
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE
        var l = Integer.MIN_VALUE

        if(A.size == 0)
            return 0

        for(num in A){
            if(num<min)
                min=num

            if(num>max)
                max=num

            if(num-min>=l){
                l=num-min
            }
        }

        return l
    }

    /**
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     * An element is a leader if it is strictly greater than all the elements to its right side.
     */
    fun solveReturnArrayOfLeaders(A: IntArray): IntArray {
        var leader = Integer.MIN_VALUE
        var leaders = ArrayList<Int>()

        for(i in A.indices.reversed()){
            val num = A[i]
            if(num > leader){
                leader = num
                leaders.add(num)
            }
        }
        return leaders.reversed().toIntArray()
    }
}