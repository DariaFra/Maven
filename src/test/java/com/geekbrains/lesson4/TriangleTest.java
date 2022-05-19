package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;

public class TriangleTest {
    @BeforeAll
    static void beforAll() {

        System.out.println("Метод выполнился один раз перед всеми тестами класса");
    }

    @BeforeEach
    void beforeEach() {

        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    void area() {
        double result = Triangle.triangleArea(5, 5, 5);
        System.out.println(round(result));
        Assertions.assertEquals(round(result), 10.83);
    }

    double round(double num) {
        return Double.parseDouble(String.format("%.2f",num).replace(",", "."));
    }


    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после теста");
    }

    @AfterAll
    static void afterAll() {

        System.out.println("Метод выполнится после всех тестов");
    }

}
