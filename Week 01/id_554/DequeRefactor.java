package com.kkkkkk.demovvorld;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String peekElement = deque.peekFirst();
        System.out.println(peekElement);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

//        Stack<String> stack = new Stack<>();
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//        System.out.println(stack);
//        while (stack.size() > 0) {
//            System.out.println(stack.pop());
//        }
//
//        Queue<String> queue = new LinkedList<>();
//        queue.add("a");
//        queue.add("b");
//        queue.add("c");
//        System.out.println(queue);
//        while (queue.size() > 0) {
//            System.out.println(queue.remove());
//        }
    }

//    static int fib(int n) {
//        if (n < 2) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }
}


