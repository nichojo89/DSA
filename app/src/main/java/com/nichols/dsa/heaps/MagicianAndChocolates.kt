package com.nichols.dsa.heaps

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class MagicianAndChocolates {

    fun getAllElements(A: TreeNode?, B: TreeNode?): Int {
        var root1 = A
        var root2 = B
        val S1: Stack<TreeNode> = Stack()
        val S2: Stack<TreeNode> = Stack()
        var result = 0L
        while (root1 != null || root2 != null || !S1.empty() || !S2.empty()) {
            while (root1 != null) {
                S1.push(root1)
                root1 = root1.left
            }
            while (root2 != null) {
                S2.push(root2)
                root2 = root2.left
            }
            if (S2.empty() || !S1.empty() && S1.peek().`val` <= S2.peek().`val`) {
                root1 = S1.pop()
                result += root1.`val`
                root1 = root1.right
            } else {
                root2 = S2.pop()
                result += root2.`val`
                root2 = root2.right
            }
        }
        val mod = (1000000000 + 7)
        return result.toInt() % mod
    }
    fun solve(A: Array<String>, B: Array<String>): IntArray {
        val test = intArrayOf()
        for(i in B.indices)
            if(A.contains(B[i]))
                test[i] = 1
            else
                test[i] = 0
        return test
    }
//    fun nchoc(A: Int, B: IntArray): Int {
//    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun nchoc(A: Int, B: IntArray): Int {
        var A = A
        val MOD = 1000000007

        val comp = Comparator<Int> { o1, o2 -> o2!! - o1!! }
        val pq = PriorityQueue(comp)
        for (choc in B) {
            pq.add(choc)
        }
        var total: Long = 0
        while (A-- > 0) {
            val choc: Int = pq.poll()
            total += choc.toLong()
            total %= MOD.toLong()
            pq.add(choc / 2)
        }
        return total.toInt()
    }
}