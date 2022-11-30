package com.nichols.dsa;

import java.util.HashSet;

public class SudukoJV {
    public int isValidSudoku(final String[] A) {
        HashSet<Character> hs = new HashSet();
        //rows
        for(int i = 0; i < 9; i++){
            hs.clear();
            for(int j = 0; j < 9; j++){
                if(A[i].charAt(j) == '.')
                    continue;

                if(hs.contains(A[i].charAt(j)))
                    return 0;
                hs.add(A[i].charAt(j));

            }
        }
        hs.clear();
        //columns
        for(int i = 0; i < 9; i++){
            hs.clear();
            for(int j = 0; j < 9; j++){
                if(A[j].charAt(i) == '.')
                    continue;

                if(hs.contains(A[j].charAt(i)))
                    return 0;

                hs.add(A[j].charAt(i));
            }
        }
        hs.clear();
        //boxes
        int x = 0;
        int y = 0;

        for(int i = 0; i < A.length; i++){
            if(i == 3)
                return 1;

            if(y >=9)
                y = 0;

            for(int j = 0; j < A[i].length(); j++){
                int row = (j/3) + x;
                int col = (j%3) + y;
                Character ele = A[row].charAt(col);

                if(ele == '.')
                    continue;
                if(hs.contains(ele))
                    return 0;

                hs.add(ele);
            }
            hs.clear();
            x +=3;
            y += 3;
        }
        return 1;
    }
}
