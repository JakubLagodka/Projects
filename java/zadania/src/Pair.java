public class Pair {
    private int firstNumber;
    private int secondNumber;

    public Pair(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}
