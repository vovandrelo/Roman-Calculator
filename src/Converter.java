public class Converter {
    private static final String[] ROMAN_NUMBERS = {
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

    public Expression parseInputStr(String expression) {
        String[] expressionElements = expression.split(" ");
        byte operation;
        int firstNumber, secondNumber;
        boolean isRomanResult = false;

        operation = expressionElements[1].getBytes()[0];

        try {
            firstNumber = Integer.parseInt(expressionElements[0]);
            secondNumber = Integer.parseInt(expressionElements[2]);
        } catch (NumberFormatException error) {
            isRomanResult = true;
            firstNumber = -1;
            secondNumber = -1;
            for (int i = 0; i < 10; i++) {
                if (expressionElements[0].equals(ROMAN_NUMBERS[i])) {
                    firstNumber = i + 1;
                }
                if (expressionElements[2].equals(ROMAN_NUMBERS[i])) {
                    secondNumber = i + 1;
                }
            }
        }

        return new Expression(firstNumber, secondNumber, operation, isRomanResult);
    }

    public String parseResult(int result, boolean isRomanResult) {
        String finalResult = Integer.toString(result);

        if (isRomanResult) {
            for (int i = 0; i < ROMAN_NUMBERS.length; i++) {
                if (finalResult.equals(Integer.toString(i + 1))) return ROMAN_NUMBERS[i];
            }
        }

        return finalResult;
    }
}

