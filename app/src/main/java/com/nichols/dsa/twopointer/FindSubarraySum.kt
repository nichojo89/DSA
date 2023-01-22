package com.nichols.dsa.twopointer

fun solveConseqSubseq(arr: IntArray, n: Int): Int {
    val hs = HashSet<Int>()
    var ans = 0

    for (i in 0 until n)
        hs.add(arr[i])

    for (i in 0 until n) {
        if (!hs.contains(arr[i] - 1)) {
            var j = arr[i]

            while (hs.contains(j)) {
                hs.remove(j)
                j++
            }

            if (ans < j - arr[i])
                ans = j - arr[i]
        }
    }
    return ans
}
fun solveShaggy(A: IntArray): Int {
    val last = hashMapOf<Int,Int>()
    for(i in A.indices)
        last[A[i]] = -1
    var res = 1e9.toInt()
    for(i in A.indices){
        if(last[A[i]] != -1){
            res = Math.min(res, i - last[A[i]]!!)
        }
        last[A[i]] = i
    }
    return if(res == 1e9.toInt())
        -1
    else
        res
}

fun solve(A: IntArray, B: Int): Int {
    val n = A.size
    var ans = -1
    var diff = 1000000000
    A.sort()

    for(i in A.indices){
        var j = i+1
        var k = n-1
        while(j<k){
            if(Math.abs(A[i] + A[j] -B)<diff){
                diff = Math.abs(A[i] + A[j] + A[k] - B)
                ans = A[i] + A[j] + A[k]
            }
            if (A[i] + A[j] + A[k] > B)
                k--
            else
                j++
        }
    }
    return ans
}
//
//public int threeSumClosest(int[] A, int B) {
//    int n = A.length, diff = 1000000000, ans = -1;
//    Arrays.sort(A);
//    // fix the smallest number of the three integers
//    for (int i = 0; i < n; i++) {
//        int j = i + 1, k = n - 1;
//        while (j < k) {
//            if (Math.abs(A[i] + A[j] + A[k] - B) < diff) {
//                diff = Math.abs(A[i] + A[j] + A[k] - B);
//                ans = A[i] + A[j] + A[k];
//            }
//            if (A[i] + A[j] + A[k] > B)
//                k--;
//            else
//                j++;
//        }
//    }
//    return ans;
//}
