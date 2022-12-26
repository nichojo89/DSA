package com.nichols.dsa.recursion

fun main(){
    generateParenthesis(3)
}
fun generateParenthesis(A: Int): Array<String> {
    generate("",0,0,A)
    val temp = Array<String>(ans.size){""}
    for(i in ans.indices){
        temp[i] = ans[i]
    }
    return temp
}

private val ans = ArrayList<String>()

fun generate(curr: String, o: Int, c: Int, A: Int){
    //    if(A == o && A == c){
    if (o == A && c == A) {
        ans.add(curr)
        return
    }

    //    if(o > A || c > A)
    //        return

    //choice #1
    if(o < A){
        generate("$curr(",o+1,c,A)
    }

    //choice #2
    //    if(o>c){
    if (c < o) {
        generate("$curr)",o,c+1,A)
    }
}