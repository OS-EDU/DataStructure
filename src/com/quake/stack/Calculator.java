package com.quake.stack;

/**
 * @author AKA二夕
 * @create 2020-07-01 16:01
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "7*21*2-5+1-5+3-4+2/1";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(100);
        ArrayStack2 operStack = new ArrayStack2(100);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        char oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫面得到的运算符保存到ch
        String keepNum = "";//用于拼接 多位数
        //开始whil循环的扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么符号，然后做出相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作运算符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数
                    //再从符号栈中pop出一个符号，进行运算，将得到的结果，入数栈，然后将当前的运算符入符号栈
                    if (operStack.priority(ch) <= operStack.priority((char) operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {//如果是数，则直接入数栈
//                numStack.push(ch - 48);// ? "1+3" '1' => 1
                /**
                 * 分析思路：
                 * 1、当处理多位数时，不能发现是一个数就立即入栈，因为它有可能是多位数
                 * 2、在处理数时，需要向expression的表达式的index 后再看一位，如果是数就进行扫描，如果是符号才入栈
                 * 3、因此需要定义一个变量 字符串，用于拼接
                 */

                //处理多位数
                keepNum += ch;

                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));//Integer将字符串转化为整型
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是最后一位，不是index++
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 ”123“
                        numStack.push(Integer.parseInt(keepNum));
                        //重要！！！！！，keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index + 1，并判断是否扫描到expr最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            //  如果符号栈为空，则运算到最后的结果，数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = (char) operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d\n",expression,res2);
    }
}

// 定义一个ArrayStack2 表示栈
class ArrayStack2 {
    private int[] stack;// 数组，用于模拟栈，数据就存放在该数组
    private int maxSize;// 栈的大小
    private int top = -1;// 表示栈顶，初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈 —— push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 —— pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 增加一个方法，可以返回当前栈顶的值，但不是真正的top
    public int peek() {
        return stack[top];
    }

    // 判断是否是运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 返回运算符的优先级，优先级是由程序猿来确定的，使用数字表示
    // 这里规定：优先级越高，返回的数字越大
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;// 假定目前表达式的运算符只有+、-、*、/
        }
    }

    // 计算方法
    public int cal(int num1, int num2, char oper) {
        int res = 0;// res用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}