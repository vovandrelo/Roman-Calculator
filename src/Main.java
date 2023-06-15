import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String expression = scan.nextLine();
        Validator.validateExpression(expression);

        Expression expressionStruct = converter.parseInputStr(expression);
        Validator.validateNumber(expressionStruct.getNumbers()[0]);
        Validator.validateNumber(expressionStruct.getNumbers()[1]);
        Validator.validateOperation(expressionStruct.getOperation());

        int result = Calculator.generateResult(
                expressionStruct.getNumbers()[0],
                expressionStruct.getNumbers()[1],
                expressionStruct.getOperation()
        );
        Validator.validateResult(result, expressionStruct.checkIsRomanResult());

        System.out.println("Результат: " + converter.parseResult(result, expressionStruct.checkIsRomanResult()));
    }
}
