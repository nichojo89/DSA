package com.nichols.dsa.backtracking

fun main(){
    val g = UniquePermutations().permute(intArrayOf(10, 9, 10, 9, 10 ))
    val f = UniquePermutations().solve(
        intArrayOf(0,0,1,1),
        arrayOf("hack", "hacker", "hac", "hak")
        )
}
class UniquePermutations {
    fun solve(A: IntArray, B: Array<String>): IntArray {
        val ans = arrayListOf<Int>()
        //BRUTE FORCE
        for(i in A)
            ans.add(B.count{it.contains(B[i])})

        return ans.toIntArray()
    }
    fun permute(A: IntArray): Array<IntArray> {
        val result = arrayListOf<IntArray>()
        val n = A.size
        var currentPermutation = ArrayList<Int>(n)
        //Create freq map to store numbers 0-9
        val freqMap = HashMap<Int,Int>()

        for(i in 0..10)
            freqMap[i] = 0
        for(i in A)
            if(freqMap.containsKey(i))
                freqMap[i] = freqMap[i]!! + 1
            else
                freqMap[i] = 1



        generate(result,freqMap,currentPermutation,n)

        return result.toTypedArray()
    }
    private fun generate(result: ArrayList<IntArray>,
                         hash: HashMap<Int,Int>,
                         current: ArrayList<Int>,
                         n : Int){
        //We've filled the current permutation
        if(current.size==n)
            result.add(current.toIntArray())

        for(i in 0..10){
            //is element present in hashmap
            if(hash[i]!! > 0){
                //deduct from frequency array
                hash[i] = hash[i]!! - 1
                //add elem to current permutation
                current.add(i)
                //Keep trying element until frequency is zero
                generate(result,hash,current,n)
                //Increase/add back to freq count after recursion
                hash[i] = hash[i]!! + 1
                //pop out of current permutation and get next
                current.removeLast()
            }
        }
    }
}