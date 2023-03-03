package com.nichols.dsa.queues

import java.util.*

class RepeatingCharacters {
    fun solve(A: String): String {
        var mp = hashMapOf<Char,Int>()
        var q : Queue<Char> = LinkedList()
        var ans = ""
        for(c in A){
            if(mp.containsKey(c))
                mp[c] = mp[c]!! + 1
            else
                mp[c] = 1

            q.add(c)
            while(!q.isEmpty() && mp[q.peek()]!! > 1){
                q.remove()
            }
            if(!q.isEmpty()){
                ans += q.peek()
            } else {
                ans += "#"
            }
        }

        return ans
    }
}