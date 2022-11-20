//package com.nichols.dsa;
//
//public class ComplexNumber {
//    float real, imaginary;
//
//    public ComplexNumber(float r, float i){
//        real = r;
//        imaginary = i;
//    }
//
//    ComplexNumber add(ComplexNumber x){
//        float r = real + x.real;
//        float i = imaginary + x.imaginary;
//        return new ComplexNumber(r,i);
//    }
//
//    ComplexNumber subtract(ComplexNumber x){
//        float r = real - x.real;
//        float i = imaginary - x.imaginary;
//        return new ComplexNumber(r,i);
//    }
//
//    ComplexNumber multiply(ComplexNumber x){
//        float r = real * x.real;
//        float i = imaginary * x.imaginary;
//        return new ComplexNumber(r,i);
//    }
//
//    ComplexNumber divide(ComplexNumber x){
//        float r = real / x.real;
//        float i = imaginary / x.imaginary;
//        return new ComplexNumber(r,i);
//    }
//}
//
//
///*
//    ComplexNumber a = new ComplexNumber(10, 5)
//	ComplexNumber b = new ComplexNumber(2, 3)
//
//	ComplexNumber c2 = a.subtract(b)
//	ComplexNumber c3 = a.multiply(b)
//	ComplexNumber c4 = a.divide(b)
//
//*/
//
//
//class Fraction {
//    int numerator, denominator;
//    Fraction(int n, int d){
//        numerator = n;
//        denominator = d;
//    }
//
//    Fraction add(Fraction a){
//        // Complete the function
//        if(denominator ==  a.denominator)
//            return new Fraction(numerator + a.numerator,denominator);
//        else {
//            int i = 0;
//            while(denominator != a.denominator){
//                denominator *= denominator;
//                a.denominator *= denominator;
//                i++;
//            }
//
//        }
//    }
//
//    Fraction subtract(Fraction a){
//        // Complete the function
//
//    }
//
//    Fraction multiply(Fraction a){
//        // Complete the function
//
//    }
//}
////
///*
//    Fraction x = new Fraction(2, 3)  // 2/3
//	Fraction y = new Fraction(4, 5) // 4/5
//    Fraction z = x.add(y) // 22/15
//    Fraction z = x.subtract(y) // -2/15
//    Fraction z = x.multiply(y) // 8/15
//*/