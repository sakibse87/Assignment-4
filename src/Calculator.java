public class Calculator {

    private int currentValue = 0;

    // Resets the calculator to zero
    public void reset() {
        currentValue = 0;
    }

    // Add a non-negative integer to currentValue.
    // If the number is negative, throw IllegalArgumentException.
    // Use Math.addExact() to detect integer overflow.
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }

        currentValue = Math.addExact(currentValue, number);
    }

    // Returns the current calculator value
    public int getCurrentValue() {
        return currentValue;
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(10);
        calculator.add(20);
        calculator.add(30);

        System.out.println("Current value: "
                + calculator.getCurrentValue());

        calculator.reset();

        System.out.println("After reset: "
                + calculator.getCurrentValue());

        try {
            calculator.add(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}