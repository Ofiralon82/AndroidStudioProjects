package com.example.user.testapf.data_structures.stack.array_stack;

import com.example.user.testapf.data_structures.stack.Employee;

import java.util.EmptyStackException;

//                ArrayStack stack = new ArrayStack(10);
//
//                stack.push(new Employee("Jane", "Jones", 123));
//                stack.push(new Employee("John", "Doe", 4567));
//                stack.push(new Employee("Mary", "Smith", 22));
//                stack.push(new Employee("Mike", "Wilson", 3245));
//                stack.push(new Employee("Bill", "End", 78));
//
//                //stack.printStack();
//
//                System.out.println(stack.peek());
//                //stack.printStack();
//
//                System.out.println("Popped: " + stack.pop());
//                System.out.println(stack.peek());

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}


