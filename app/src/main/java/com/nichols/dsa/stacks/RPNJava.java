package com.nichols.dsa.stacks;

import java.util.Stack;

public class RPNJava {
    public int stacky(String[] A)
    {
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";

        // Iterating to the each character
        // in the array of the string
        for (int i = 0; i < A.length; i++) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            if (A[i] != "+" && A[i] != "-"
                    && A[i] != "*" && A[i] != "/") {
                stack.push(A[i]);
                continue;
            }
            else {
                // else if the character is the special
                // character then use the switch method to
                // perform the action
                choice = A[i];
            }

            // Switch-Case
            switch (choice) {
                case "+":

                    // Performing the "+" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "-":

                    // Performing the "-" operation by popping
                    // put the first two character
                    // and then again store back to the stack
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;

                case "*":

                    // Performing the "*" operation
                    // by popping put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "/":

                    // Performing the "/" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;

                default:
                    continue;
            }
        }

        // Method to convert the String to integer
        return Integer.parseInt(stack.pop());
    }
}
