package com.nichols.dsa.sorting

class SortInversion {
    private val Mod = 1000 * 1000 * 1000 + 7
    fun solve(A: IntArray): Int {
        return mergeSort(A).toInt()
    }

    fun mergeSort(A: IntArray): Long {
        val temp = IntArray(A.size)
        return _mergeSort(A, temp, 0, A.size - 1) % Mod
    }

    fun _mergeSort(arr: IntArray, temp: IntArray, left: Int, right: Int): Long {
        val mid: Int
        var inv_count: Long = 0
        if (right > left) {
            mid = (right + left) / 2
            inv_count += _mergeSort(arr, temp, left, mid)
            inv_count += _mergeSort(arr, temp, mid + 1, right)
            inv_count += merge(arr, temp, left, mid + 1, right)
        }
        return inv_count % Mod
    }

    fun merge(arr: IntArray, temp: IntArray, left: Int, mid: Int, right: Int): Long {
        var i: Int
        var j: Int
        var k: Int
        var inv_count: Long = 0
        i = left
        j = mid
        k = left
        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++] else {
                temp[k++] = arr[j++]
                inv_count = inv_count + (mid - i)
            }
        }
        while (i <= mid - 1)
            temp[k++] = arr[i++]
        while (j <= right)
            temp[k++] = arr[j++]

        i = left
        while (i <= right) {
            arr[i] = temp[i]
            i++
        }
        return inv_count % Mod
    }
}