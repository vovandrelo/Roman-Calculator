public class Validator {
    public static void validateExpression(String expression) throws Exception {
        String[] expressionElements = expression.split(" ");
        if (expressionElements.length != 3) {
            throw new Exception("Error! Введено некорректное выражение");
        }
    }
    public static void validateNumber(int number) throws Exception {
        if (number < 1 || number > 10) {
            throw new Exception("Error! Числа должны быть в одинаковой системе счисления и находиться в диапазоне от 1 до 10");
        }
    }
    public static void validateOperation(Byte operation) throws Exception {
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            throw new Exception("Error! Некорректная операция");
        }
    }
    public static void validateResult(int result, boolean isRomanResult) throws Exception {
        if (result < 1 && isRomanResult) {
            throw new Exception("Error! Римская система счисления неподдерживает отрицательные числа");
        }
    }
}
