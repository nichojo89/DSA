package com.nichols.dsa

fun main(){
//    val ans = solveLargestNumberThree(intArrayOf(8,89))
    val ans = solveContinuousSum(5, arrayOf(intArrayOf(1,2,10), intArrayOf(2,3,20), intArrayOf(2,5,25)))
}

fun solveContinuousSum(A: Int, B: Array<IntArray>): IntArray {
    val arr = IntArray(A)
    for(q in B){
        val s = q[0]
        val e = q[1]
        val v = q[2]
        for(i in s-1 until e)
            arr[i] += v
    }
    return arr
}

fun kadanesBetterAlgo(A: IntArray): Int {
    var localMax = 0
    var globalMax = Integer.MIN_VALUE
    for(i in A.indices){
        localMax = Math.max(A[i], localMax + A[i])
        if(localMax > globalMax)
            globalMax = localMax
    }
    return globalMax
}

fun kadanesAlgo(A: IntArray) : Int{

    var maxEnding = 0
    var maxSoFar = Integer.MIN_VALUE
    for(i in A.indices){
        maxEnding += A[i]

        if(maxEnding > maxSoFar)
            maxSoFar = maxEnding

        if(maxEnding < 0)
            maxEnding = 0
    }
    return maxSoFar
}

fun solveLargestNumberThree(A: IntArray) : String {
    var allZeros = true
    val s = A.sortedWith(object : Comparator<Int>{
        override fun compare(o1: Int?, o2: Int?): Int {
            val oneTwo = "$o1$o2".toLong()
            val twoOne = "$o2$o1".toLong()
            if(o1!! + o2!! != 0)
                allZeros = false
            return if(oneTwo > twoOne) -1  else 1
        }
    })
        .map{it.toString()}
        .joinToString(separator = "")

    return if(A.size == 1) A[0].toString()
    else if(allZeros) "0"
    else s
}
fun solve(A: Int, B: Long): Int = findRecursive(A, B)

fun findRecursive(n: Int, k: Long): Int{
    if(k==0L)
        return 0

    val v = findRecursive(n- 1 , k / 2);
    if(k % 2 == 0L){
        return v
    }
    return 1 - v
}

//static void printLargest(Vector<String> arr)
//{
//
//    Collections.sort(arr, new Comparator<String>()
//    {
//        // A comparison function which is used by
//        // sort() in printLargest()
//        @Override public int compare(String X, String Y)
//        {
//
//            // first append Y at the end of X
//            String XY = X + Y;
//
//            // then append X at the end of Y
//            String YX = Y + X;
//
//            // Now see which of the two
//            // formed numbers
//            // is greater
//            return XY.compareTo(YX) > 0 ? -1 : 1;
//        }
//    });
//
//    Iterator it = arr.iterator();
//
//    while (it.hasNext())
//        System.out.print(it.next());
//}
//fun solveLargestNumberTwo(A: IntArray) : String {
//    var result = ""
//    var str = arrayListOf<String>()
//    for(i in A.indices){
//        str.add(A[i].toString())
//    }
//    str.sort()
//    for(i in str.indices){
//        result += str[i]
//    }
//    var pos = 0
//    while(result[pos] == '0' && pos + 1 < result.length){
//        pos++
//    }
//    return result.substring(pos)
//}