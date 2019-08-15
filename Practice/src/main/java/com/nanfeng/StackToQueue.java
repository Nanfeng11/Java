package com.nanfeng;

import java.util.Stack;

/**
 * Author：nanfeng
 * Created:2019/8/15
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                int v = stack1.pop();
                stack2.push(v);
            }
        }
        int v = stack2.pop();
        return v;
    }
}
