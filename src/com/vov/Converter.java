package com.vov;

public class Converter {
    private int firstNum = -1, secondNum = -1;
    private boolean isRomanResult = false;
    private Byte operation;
    private static final String[] romanNumbers  = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };


    public void parseInputStr(String expression) throws Exception {
        String[] expressionElements = expression.split(" ");

        if (expressionElements.length != 3) {
            throw new Exception("Error! Введено некорректное выражение");
        }

        int firstNumber = parseNumber(expressionElements[0]);
        int secondNumber = parseNumber(expressionElements[2]);
        byte operation = expressionElements[1].getBytes()[0];

        boolean firstNumberIsRoman = checkNumberIsRoman(expressionElements[0]);
        boolean secondNumberIsRoman = checkNumberIsRoman(expressionElements[2]);

        if (firstNumberIsRoman != secondNumberIsRoman) {
            throw new Exception("Error! Числа должны быть единой системы счисления");
        }

        if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
            throw new Exception("Error! Числа должны находиться в диапазоне от 1 до 10");
        }

        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            throw new Exception("Error! Некорректная операция");
        }

        this.firstNum = firstNumber;
        this.secondNum = secondNumber;
        this.isRomanResult = secondNumberIsRoman;
        this.operation = operation;
    }
    private int parseNumber(String someNum) throws Exception {
        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i + 1);

            if (someNum.equals(index)) return Integer.parseInt(someNum);
            if (someNum.equals(romanNumbers[i])) return this.firstNum = i + 1;
        }
        throw new Exception("Error! Некорректное число");
    }

    private boolean checkNumberIsRoman(String someNum) throws Exception {
        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i + 1);

            if (someNum.equals(index)) return false;
            if (someNum.equals(romanNumbers[i])) return true;
        }
        throw new Exception("Error! Некорректное число");
    }

    public String parseResult(int result) throws Exception {
        if (result < 1 && this.isRomanResult) {
            throw new Exception("Error! Римская система счисления неподдерживает отрицательные числа");
        }

        String finalResult = Integer.toString(result);

        if (this.isRomanResult) {
            for (int i = 0; i < romanNumbers.length; i++) {
                String index = Integer.toString(i + 1);

                if (finalResult.equals(index)) return romanNumbers[i];
            }
        }

        return finalResult;
    }

    public int[] getNumbers() {
        return new int[]{ this.firstNum, this.secondNum };
    }
    public byte getOperation() {
        return this.operation;
    }
}

