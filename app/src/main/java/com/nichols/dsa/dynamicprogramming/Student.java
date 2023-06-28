package com.nichols.dsa.dynamicprogramming;

class Point
{
    int y;
    int x;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Rectangle
{
    Point topLeft;
    int height;
    int width;

    int getArea(){
        return height * width;
    }
    int getParameter(){
        return (width+height)*2;
    }
    Point getBottomRight(){
        return new Point(width,height);
    }
}
public class Student {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

    void sayHello(String name){
        System.out.println(this.name + " says hello to " + name);
    }
}
