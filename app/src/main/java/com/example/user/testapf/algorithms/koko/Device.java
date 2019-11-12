package com.example.user.testapf.algorithms.koko;

import java.util.Stack;

public class Device
{

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; s.length() > i ; i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
                continue;
            }

            if (curr == ')' && stack.peek() == '(') {
                stack.pop();
            }else {
                return false;
            }

            if (curr == '}' && stack.peek() == '{') {
                stack.pop();
            }else {
                return false;
            }

            if (curr == ']' && stack.peek() == '[') {
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
