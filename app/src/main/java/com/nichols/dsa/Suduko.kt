package com.nichols.dsa

fun main(){
    val a = arrayOf(
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79")
    val b = arrayOf(
        "....5..1.",
        ".4.3.....",
        ".....3..1",
        "8......2.",
        "..2.7....",
        ".15......",
        ".....2...",
        ".2.9.....",
        "..4......")
    val ansTwo = isValidSudoku(b)
    //val ans = isValidSudoku(a)
}
fun isValidSudoku(A: Array<String>): Int {
    val hs = hashSetOf<Char>()
    //rows
    for(i in A.indices){
        hs.clear()
        for(j in 0 until 9){

            if(A[i][j] == '.')
                continue;

            if(hs.contains(A[i][j]))
                return 0

            hs.add(A[i][j])
        }
    }
    hs.clear()

    //columns
    for(i in A.indices){
        hs.clear()
        for(j in 0 until 9){

            if(A[j][i] == '.')
                continue;

            if(hs.contains(A[j][i]))
                return 0

            hs.add(A[j][i])
        }
    }
    //boxes
    hs.clear()
    var x = 0
    var y = 0

    for(i in A.indices) {


        if(y >= 9)
            y = 0


        for(j in A[i].indices){
            val row = (j/3) + x
            val col = (j%3) + y
            val ele = A[row][col]
//            println("Row $row Col $col")
//            println("Row $row Col $col Ele $ele")

            if(ele == '.')
                continue

            if(hs.contains(ele))
                return 0

            hs.add(ele)

        }
//        println("-------------")
        hs.clear()
        y += 3
        if((i+1)%3 == 0 && i != 0)
            x += 3
    }
    return 1
}