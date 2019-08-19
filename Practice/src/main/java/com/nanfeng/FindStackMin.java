package com.nanfeng;

import java.util.Stack;

/**
 * Author：nanfeng
 * Created:2019/8/19
 */
public class FindStackMin {
    Stack<Integer> total = new Stack<Integer>();
    Stack<Integer> little = new Stack<Integer>();

    public void push(int node) {
        total.push(node);
        if(little.empty()){
            little.push(node);
        }else{
            if(little.peek() <= node){
                little.push(little.peek());
            }else{
                little.push(node);
            }
        }
    }

    public void pop() {
        total.pop();
        little.pop();
    }

    public int top() {
        return total.peek();
    }

    public int min() {
        return little.peek();
    }
}
