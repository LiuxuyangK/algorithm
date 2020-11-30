package suanfa.year_2020.month_11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day28 {
    public static void main(String[] args) {

    }

    //阅读：https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/2.4-shou-ba-shou-she-ji-shu-ju-jie-gou/dui-lie-shi-xian-zhan-zhan-shi-xian-dui-lie

}

/**
 * 队列实现栈：https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
class MyStack {

    private Deque<Integer> q1;
    private Deque<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (q1.isEmpty()) {
            return q2.getLast();
        } else {
            return q1.getLast();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * 用栈实现队列：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
class MyQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> helpStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        mainStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //如果负责出栈的栈，空了，那么就从mainStack中搬运过来
        if (helpStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                Integer pop = mainStack.pop();
                helpStack.push(pop);
            }
        }
        return helpStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //如果负责出栈的栈，空了，那么就从mainStack中搬运过来
        if (helpStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                Integer pop = mainStack.pop();
                helpStack.push(pop);
            }
        }
        return helpStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return mainStack.isEmpty() && helpStack.isEmpty();
    }
}
