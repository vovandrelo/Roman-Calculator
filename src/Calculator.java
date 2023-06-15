public class Calculator {
    public static int generateResult(int num1, int num2, byte operation) {
        return switch (operation) {
            case ('+') -> num1 + num2;
            case ('-') -> num1 - num2;
            case ('*') -> num1 * num2;
            case ('/') -> num1 / num2;
            default -> 0;
        };
    }
}
