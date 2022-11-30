package com.nichols.dsa;

import java.util.Scanner;

class Matrix {
    // Define properties here
    int row, column;
    int[][] mat;

    // Define constructor here
    Matrix(int r, int c){
        this.row = r;
        this.column = c;
        this.mat = new int[r][c];
    }

    void input(Scanner sc){
        for(int i = 0 ; i < this.row ; i++){
            for(int j = 0 ; j < this.column ; j++){
                mat[i][j] = sc.nextInt();;
            }
        }
    }

    Matrix add(Matrix x){
        Matrix res = new Matrix(this.row , this.column);
        for(int i = 0 ; i < this.row ; i++){
            for(int j = 0 ; j < this.column ; j++){
                res.mat[i][j] = this.mat[i][j] + x.mat[i][j];
            }
        }
        return res;
    }

    Matrix subtract(Matrix x){
        Matrix res = new Matrix(this.row , this.column);
        for(int i = 0 ; i < this.row ; i++){
            for(int j = 0 ; j < this.column ; j++){
                res.mat[i][j] = this.mat[i][j] - x.mat[i][j];
            }
        }
        return res;
    }

    Matrix transpose(){
        Matrix res = new Matrix(this.column , this.row);
        for(int i = 0 ; i < this.row ; i++){
            for(int j = 0 ; j < this.column ; j++){
                res.mat[j][i] = this.mat[i][j];
            }
        }
        return res;
    }

    void print(){
        for(int i = 0 ; i < this.row ; i++){
            for(int j = 0 ; j < this.column ; j++){
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}


//class Matrix {
//    // Define properties here
//    ArrayList<int[]> rows;
//    int _maxLength;
//
//
//    // Define constructor here
//    Matrix(int r, int c) {
//        rows = new ArrayList();
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    void input(Scanner sc) {
//        int i = 0;
//        while (sc.hasNextLine()) {
//            //read input
//            String s = sc.nextLine();
//            if(s.length() > 0){
//                //convert input to row array
//                int[] row = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
//                //add row to matrix
//                rows.add(row);
//                i++;
//                //set column length
//                if (row.length > _maxLength)
//                    _maxLength = row.length;
//            }
//        }
//    }
//
//    Matrix add(Matrix x) {
//        for (int i = 0; i < rows.size() - 1; i++) {
//            for (int j = 0; j < _maxLength - 1; j++) {
//                rows.get(i)[j] += x.rows.get(i)[j];
//            }
//        }
//        return this;
//    }
//
//    Matrix subtract(Matrix x) {
//        for (int i = 0; i < rows.size() - 1; i++) {
//            for (int j = 0; j < _maxLength - 1; j++) {
//                rows.get(i)[j] -= x.rows.get(i)[j];
//            }
//        }
//        return this;
//    }
//
//    Matrix transpose() {
//        return this;
////        int rowCount = rows.size();
////        int colCount = _maxLength;
////        int[][] transposed = new int[rowCount][colCount];
////
////        //for each row
////        for (int i = 0; i < rows.size() - 1; i++) {
////            //for each array
////            for (int j = 0; j < rows.get(i).length - 1; i++) {
////                //swap values in transposed fashion
////                int temp = rows.get(i)[j];
////
////                if (i >= transposed.length || j > transposed[i].length - 1) {
////                    transposed[j][i] = temp;
////                } else {
////                    transposed[i][j] = rows.get(j)[i];
////                    transposed[j][i] = temp;
////                }
////            }
////        }
////        Matrix t = new Matrix(rowCount, colCount);
////        t.rows = transposed;
////        return t;
//    }
//
//    void print() {
//        for (int i = 0; i < rows.size() - 1; i++) {
//            for (int j = 0; j < _maxLength - 1; j++) {
//                System.out.print(rows.get(i)[j]);
//            }
//            System.out.println();
//        }
//    }
//}