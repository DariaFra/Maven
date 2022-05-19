package com.geekbrains.lesson4;

public class Triangle {


    public static void main(String[] args) {
        double area;
        //area = triangleArea(5, 5, 5);
        //System.out.println("triangleArea= " + area);
    }

    public static double triangleArea(int a, int b, int c) {
        double pp = (a + b + c) / 2.0;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }
}





