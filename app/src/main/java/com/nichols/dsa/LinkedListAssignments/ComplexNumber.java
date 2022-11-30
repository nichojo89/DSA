package com.nichols.dsa.LinkedListAssignments;
//class ComplexNumber {
//    // Define properties here
//    float real, imaginary;
//
//    // Define constructor here
//    ComplexNumber(float x, float y){
//        this.real = x;
//        this.imaginary = y;
//    }
//
//    ComplexNumber add(ComplexNumber x){
//        // Complete the function
//        return new ComplexNumber(this.real + x.real , this.imaginary + x.imaginary);
//    }
//
//    ComplexNumber subtract(ComplexNumber x){
//        // Complete the function
//        return new ComplexNumber(this.real - x.real , this.imaginary - x.imaginary);
//    }
//
//    ComplexNumber multiply(ComplexNumber x){
//        // Complete the function
//        float r =  x.real * this.real - x.imaginary * this.imaginary;
//        float i = this.imaginary * x.real + this.real * x.imaginary;
//        return new ComplexNumber(r, i);
//    }
//
//    ComplexNumber divide(ComplexNumber x){
//        // Complete the function
//        float r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
//        float i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
//        return new ComplexNumber(r, i);
//    }
//}
public class ComplexNumber {
    float real, imaginary;

    public ComplexNumber(float r, float i){
        real = r;
        imaginary = i;
    }

    ComplexNumber add(ComplexNumber x){
        float r = real + x.real;
        float i = imaginary + x.imaginary;
        return new ComplexNumber(r,i);
    }

    ComplexNumber subtract(ComplexNumber x){
        float r = x.real - real;
        float i = x.imaginary - imaginary;
        return new ComplexNumber(r,i);
    }

    ComplexNumber multiply(ComplexNumber x){
        float r =  x.real * this.real - x.imaginary * this.imaginary;
        float i = this.imaginary * x.real + this.real * x.imaginary;
        return new ComplexNumber(r,i);
    }

    ComplexNumber divide(ComplexNumber x){
        float r = (this.real * x.real + this.imaginary * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        float i = (this.imaginary * x.real - this.real * x.imaginary) / (x.real * x.real + x.imaginary * x.imaginary);
        return new ComplexNumber(r,i);
    }
}

/*

	ComplexNumber c1 = a.add(b)
	ComplexNumber c2 = a.subtract(b)
	ComplexNumber c3 = a.multiply(b)
	ComplexNumber c4 = a.divide(b)

*/