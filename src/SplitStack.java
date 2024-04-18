import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class: Data Analysis Program ITEC 2150 - 05
 *
 * author Dakota Sison Gregory
 * version 1.0
 * course ITEC 2150 Spring 2024
 * written April 18, 2024
 *
 * This class is designed to manipulate a stack of integers, specifically
 * rearranging them such that all negative numbers are at the bottom of the stack
 * and all non-negative numbers are on top. The program utilizes a single queue
 * as auxiliary storage to achieve this reordering.
 */


public class SplitStack {

    public static void splitStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        // Transfer all elements from stack to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Put non-negatives back on the stack
        for (Integer num : queue) {
            if (num >= 0) {
                stack.push(num);
            }
        }

        // Put negatives in the queue again
        for (Integer num : queue) {
            if (num < 0) {
                stack.push(num);
            }
        }

        // Reverse stack to maintain order with negatives at bottom
        Queue<Integer> tempQueue = new LinkedList<>();
        while (!stack.isEmpty()) {
            tempQueue.add(stack.pop());
        }
        while (!tempQueue.isEmpty()) {
            stack.push(tempQueue.remove());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(-5);
        stack1.push(67);
        stack1.push(-45);
        stack1.push(67);
        stack1.push(9);
        stack1.push(0);
        stack1.push(-42);
        stack1.push(56);
        stack1.push(-7);

        splitStack(stack1);
        System.out.println("Example 1: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(-2);
        stack2.push(-3);
        stack2.push(4);
        stack2.push(-5);
        stack2.push(6);
        stack2.push(-7);
        stack2.push(8);
        stack2.push(9);

        splitStack(stack2);
        System.out.println("Example 2: " + stack2);
    }

}
