
# Assignment 4 - Version Control & AI

## 1. Program Description

This is a simple Java Calculator program.

The Calculator class stores a current integer value and provides three main methods:

- `reset()` - Resets the current value to zero.
- `add(int number)` - Adds a non-negative integer to the current value. Negative numbers are not allowed.
- `getCurrentValue()` - Returns the current value.

The program uses `Math.addExact()` to detect integer overflow.

## 2. Source Code

```java
public class Calculator {

    private int currentValue = 0;

    // Resets the calculator to zero
    public void reset() {
        currentValue = 0;
    }

    // Adds a non-negative integer
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                    "Negative numbers are not allowed"
            );
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
```

## 3. Code Explanation

### Calculator Class

The Calculator class keeps track of a running total.

`currentValue` is a private integer that stores the calculator’s current total. It starts at 0. Because it is private, other parts of the program use the class’s methods to read or change it.

The `reset()` method sets `currentValue` back to 0.

The `add(int number)` method adds a number to the running total. It first checks whether the number is negative. If it is, the method throws an `IllegalArgumentException` and does not add it. Zero and positive numbers are allowed.

`Math.addExact(currentValue, number)` adds the two integers and checks whether the result fits in Java’s `int` range. If the total would be too large, it throws an `ArithmeticException` instead of allowing the value to wrap around. Since the assignment to `currentValue` happens only after the addition succeeds, the total is unchanged when overflow occurs.

The `getCurrentValue()` method returns the current total without changing it.

The `main()` method demonstrates how to use the calculator. It creates a calculator, adds 10, 20, and 30, and prints the total (60). It then calls `reset()` and prints the new total (0). Finally, it tries to add -5. The `try` block runs that operation, and the `catch` block handles the `IllegalArgumentException` and prints its message.

## 4. How I Used GitHub Copilot

I used GitHub Copilot in three different ways to generate the `add(int number)` method.

### Method 1: Writing the Method Signature

First, I wrote the method signature:

`public void add(int number)`

I left the method body empty and asked GitHub Copilot to generate the implementation. Copilot generated code that rejects negative numbers using `IllegalArgumentException` and adds non-negative numbers using `Math.addExact()`.

### Method 2: Writing the First Line of the Method

Next, I wrote the method signature and the initial negative-number validation. I asked Copilot to complete the remaining method body using a for loop.

After that, I changed the for loop into a while loop. Both versions added the given number one unit at a time.

Copilot also explained the differences between for and while loops.

### Method 3: Writing an English Comment

Finally, I wrote English comments describing what the method should do. I asked Copilot to generate the method body based on those comments.

Copilot generated the validation and addition logic using `Math.addExact()`.

After comparing the three approaches, I selected direct addition with `Math.addExact()` for the final implementation because it is more efficient than repeatedly adding one inside a loop.

## 5. Evaluation of GitHub Copilot

### Benefits

- It helps generate code faster.
- It provides different ways to implement a method.
- It explains unfamiliar Java methods and programming concepts.
- It helps beginners understand code and improve their programming skills.

### Drawbacks

- Some suggestions may need manual checking and testing.
- Generated code may not always be the most efficient solution.
- Beginners should understand the generated code instead of copying it without reviewing.

### Conclusion

GitHub Copilot was a useful assistant during this assignment. It helped me explore different ways to write the add method, understand loops, and explain my Java code. I learned that Copilot can save time, but its suggestions should always be reviewed and tested.
