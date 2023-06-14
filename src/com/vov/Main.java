package com.vov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String expression = scan.nextLine();

        converter.parseInputStr(expression);
        int[] numbers = converter.getNumbers();
        byte operation = converter.getOperation();
        int result = Calculator.generateResult(numbers[0], numbers[1], operation);

        System.out.println("Результат: " + converter.parseResult(result));
    }
}
