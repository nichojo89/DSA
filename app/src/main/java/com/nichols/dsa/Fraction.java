package com.nichols.dsa;

public class Fraction {

    int numerator, denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }


    Fraction add(Fraction a){
        int N = Math.abs(this.numerator * a.denominator + a.denominator * this.denominator);
        int D = Math.abs(this.denominator * a.denominator);
        int gcd = gcd(N,D);

        return new Fraction(N/gcd,D/gcd);
        //  return new Fraction(0,0);
    }

    Fraction subtract(Fraction a){
        int N = Math.abs(this.numerator * a.denominator - a.denominator * this.denominator);
        int D = Math.abs(this.denominator * a.denominator);
        int gcd = gcd(N,D);

        return new Fraction(N/gcd,D/gcd);
    }

    Fraction multiply(Fraction a){
        int n =  a.numerator * numerator;
        int d = denominator * a.denominator;
        int gcd = gcd(n,d);
        return new Fraction(n/gcd,d/gcd);
        //  return new Fraction(0,0);
    }

    int gcd(int a, int b)
    {
        if(a == 0)
            return b;

        return gcd(b%a,a);
    }

    Fraction lowest(int den, int num)
    {
        int cf = gcd(num,den);
        den = den/cf;
        num = num/cf;

        return new Fraction(num,den);
    }
}