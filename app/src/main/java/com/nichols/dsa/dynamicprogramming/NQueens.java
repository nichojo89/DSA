package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static ArrayList<ArrayList<String>> answer = new ArrayList<>();

    static boolean safe(int row, int col, ArrayList<String> board) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        int i = row, j = col;
        while (i >= 0 && j >= 0)
            if (board.get(i--).charAt(j--) == 'Q')
                return false;
        i = row;
        j = col;
        while (i >= 0 && j < board.size())
            if (board.get(i--).charAt(j++) == 'Q')
                return false;
        return true;
    }

    static void rec(ArrayList<String> board, int row) {
        if (row == board.size()) {
            answer.add(board);
            return;
        }
        for (int i = 0; i < board.size(); i++)
        {
            if (safe(row, i, board)) {
                ArrayList<String> temp = new ArrayList<>(board);
                temp.set(row, temp.get(row).substring(0, i) + "Q" + temp.get(row).substring(i + 1));
                rec(temp, row + 1);
            }
        }
        return;
    }

    static ArrayList<ArrayList<String>> solveNQueens(int n)
    {
        String s = new String(new char[n]).replace("\0", ".");
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++)
            board.add(s);
        rec(board, 0);
        return answer;
    }
}
