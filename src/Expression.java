public class Expression {
    private final int firstNum, secondNum;
    private final boolean isRomanResult;
    private final Byte operation;

    public Expression(int firstNum, int secondNum, Byte operation, boolean isRomanResult) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.isRomanResult = isRomanResult;
        this.operation = operation;
    }

    public int[] getNumbers() {
        return new int[]{ this.firstNum, this.secondNum };
    }
    public byte getOperation() {
        return this.operation;
    }
    public boolean checkIsRomanResult() {
        return this.isRomanResult;
    }
}
