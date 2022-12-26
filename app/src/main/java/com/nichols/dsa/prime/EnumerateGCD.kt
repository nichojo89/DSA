package com.nichols.dsa.prime

private fun printString(columnNumber: Int) {
    // To store result (Excel column name)
    var columnNumber = columnNumber
    val columnName = StringBuilder()
    while (columnNumber > 0) {
        // Find remainder
        val rem = columnNumber % 26

        // If remainder is 0, then a
        // 'Z' must be there in output
        columnNumber = if (rem == 0) {
            columnName.append("Z")
            columnNumber / 26 - 1
        } else  // If remainder is non-zero
        {
            columnName.append((rem - 1 + 'A'.code).toChar())
            columnNumber / 26
        }
    }

    // Reverse the string and print result
    println(columnName.reverse())
}

fun solve(A: Int) : String {
    var columnNumber = A
    val columnName = StringBuilder()
    while (columnNumber > 0) {
        val rem = columnNumber % 26

        columnNumber = if (rem == 0) {
            columnName.append("Z")
            columnNumber / 26 - 1
        } else {
            columnName.append((rem - 1 + 'A'.code).toChar())
            columnNumber / 26
        }
    }
    return columnName.reverse().toString()
}