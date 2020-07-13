package com.quake.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author AKA二夕
 * @create 2020-07-13 16:05
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList =" + list);
        int res = calculate(list);
        System.out.println("计算结果是：" + res);
    }

    // 依次将一个逆波兰表达式的数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression按照空格“ ”分开
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        // 创建一个栈（在这里只需要一个栈即可）
        Stack<String> stack = new Stack<String>();
        // 遍历ls
        for (String item : ls) {
            // 使用正则表达式来取出数
            if (item.matches("\\d+")) {// 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算，再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num2 * num1;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("输入的运算符有误！！！");
                }
                // 把res入栈
                stack.push("" + res);// 加上双引号即可转换为字符串形式
            }
        }
        // 最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}
