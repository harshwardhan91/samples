package com.local;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }

    private static void printNGE(int[] arr, int n) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(arr[0]);
        int next  = -1;
        int element = -1;
        for (int i = 1; i < n; i++) {
            next = arr[i];
            if(!stack.isEmpty()) {
                element = stack.pop();
                while (element < next) {
                    System.out.println(element + " - " + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }

                if (element > next) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }

        while (stack.isEmpty()){
            element = stack.pop();
            next = -1;
            System.out.println(element + " - " + next);
        }
    }

}