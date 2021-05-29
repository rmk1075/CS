package DataStructure.Test;

import DataStructure.Stack.CustomStack;

public class StackTest {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while(stack.size() != 0) {
            int element = stack.pop();
            System.out.println(element);
        }
    }
}
