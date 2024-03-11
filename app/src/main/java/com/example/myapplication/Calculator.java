package com.example.myapplication;

import android.media.VolumeShaper;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import kotlinx.coroutines.flow.StateFlowKt;


public class Calculator {
    String inputBox;
    Stack<Double> elements = new Stack<>();
    Stack<Character> operator = new Stack<>();

    Deque<String> queue = new LinkedList<>();

    public void addOperand(String temp) {

        elements.push(Double.parseDouble(temp));
        queue.offer(temp);
    }

    public Double addOperator(char op) {
        System.out.println("The size of operator is " + operator.size());
        if (operator.size() == 0) {
            operator.push(op);
            queue.offer(String.valueOf(op));
            return 0.0;
        }

        char op2 = operator.pop();
        double a = elements.pop(), b = elements.pop();
        switch (op2) {
            case '+':
                elements.push(b + a);
                break;
            case '*':
                elements.push(b * a);
                break;
            case '/':
                if(a == 0)
                {
                    return null;
                }
                else
                {
                    elements.push(b / a);
                }
                break;
            case '-':
                elements.push(b - a);
                break;
            default:
                break;
        }
        operator.push(op);
        queue.offer(String.valueOf(op));
        return elements.peek();


    }

    public void replaceOperator(char op) {
        operator.pop();
        operator.push(op);
        queue.removeLast();
        queue.offer(String.valueOf(op));
    }

    public String storeInfixValue() {

//        Deque<String> queue = this.queue;
        Stack<Character> operators = new Stack<>();
        List<String> postfix = new ArrayList<>();

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if(isOperator(temp ) && queue.isEmpty())
            {
                continue;
            }
            if (isOperator(temp) && !queue.isEmpty()) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(temp.charAt(0))) { postfix.add(String.valueOf(operators.pop()));
                }
                operators.push(temp.charAt(0));
            } else {
                postfix.add(temp);
            }
        }

        while (!operators.isEmpty()) {
            postfix.add(String.valueOf(operators.pop()));
        }
        if(!queue.isEmpty())
        {
            postfix.add(queue.poll());
        }
        if(postfix.isEmpty())
        {
            return  "0";
        }

        return evaluatePostFix(postfix);
//        return String.join(" ", postfix);
    }


    public String evaluatePostFix(List<String> array) {
        Stack<String> temp = new Stack<>();
        double res = 0;
        double a = 0, b = 0;
        for (String item : array) {
            if (!isOperator(item)) {
                temp.push(item);
            } else {
                a = Double.parseDouble(temp.pop());
                b = Double.parseDouble(temp.pop());
                switch (item.charAt(0)) {
                    case '*':
                        temp.push(String.valueOf(b * a));
                        break;
                    case '+':
                        temp.push(String.valueOf(b + a));
                        break;
                    case '-':
                        temp.push(String.valueOf(b - a));
                        break;
                    case '/':
                        if(a == 0)
                        {
                            throw new ArithmeticException("Division by 0");
                        }
                        temp.push(String.valueOf(b / a));
                        break;

                }
            }

        }
        return temp.pop();
    }


    public boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }

    public int precedence(char op) {

        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

}