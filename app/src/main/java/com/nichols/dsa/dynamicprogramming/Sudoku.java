package com.nichols.dsa.dynamicprogramming;

public class Sudoku {
    final int N = 9;

    boolean isValid(char[][] A, int row, int col) {
        char elem = A[row][col];

        // check range
        if (elem - '0' < 1 || elem - '0' > 9) {
            return false;
        }

        // check row and column for duplicates
        for (int p = 0; p < N; ++p) {
            if (A[p][col] == elem && p != row) {
                return false;
            }
            if (A[row][p] == elem && p != col) {
                return false;
            }
        }

        // check 3x3 subgrid for duplicates
        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;

        for (int i = subRow; i < subRow + 3; ++i) {
            for (int j = subCol; j < subCol + 3; ++j) {
                if (A[i][j] == elem && (i != row || j != col)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean sudoku(char[][] A, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow, nextCol;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (A[row][col] != '.') {
            if (!isValid(A, row, col)) {
                return false;
            }
            return sudoku(A, nextRow, nextCol);
        }

        for (int i = 1; i <= N; ++i) {
            A[row][col] = (char) (i + '0');
            if (isValid(A, row, col) && sudoku(A, nextRow, nextCol)) {
                return true;
            }
        }

        A[row][col] = '.';
        return false;
    }

    public void solveSudoku(char[][] A) {
        if (A.length != N || A[0].length != N) {
            return;
        }
        sudoku(A, 0, 0);
    }
}
