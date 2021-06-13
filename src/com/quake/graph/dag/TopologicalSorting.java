package com.quake.graph.dag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AKA二夕
 * @create 2021-06-13 22:09
 */
public class TopologicalSorting {

    // 定义静态内部类
    static class Node {
        int value; // 定义一个结点
        List<Integer> next; // next 指针，指向下一个结点

        // 构造器
        public Node(int value) {
            this.value = value;
            next = new ArrayList<Integer>();
        }

        // setNext
        public void setNext(List<Integer> list) {
            this.next = list;
        }
    }

    public static void main(String[] args) {

        Node[] nodes = new Node[9]; // 储存结点
        int[] inDegree = new int[9]; // 储存入度
        List[] lists = new ArrayList[10]; // 临时空间，为了存储指向的集合

        // 生成 1 ~ 9 九个结点
        for (int i = 1; i < 9; i++) {
            nodes[i] = new Node(i);
            lists[i] = new ArrayList<Integer>();
        }

        initMap(nodes, lists, inDegree);

        // 使用队列实现
        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (int i = 1; i < 9; i++) {
            if (0 == inDegree[i]) { // 如果入度为零，则入队列
                deque.add(nodes[i]);
            }
        }

        while (!deque.isEmpty()) {
            Node node1 = deque.poll(); // 抛出输出
            System.out.print(node1.value + " ");
            List<Integer> next = node1.next;
            for (Integer integer : next) {
                inDegree[integer]--; //  入度减一
                if (0 == inDegree[integer]) { // 如果入度为零
                    deque.add(nodes[integer]);
                }
            }
        }

    }

    private static void initMap(Node[] nodes, List<Integer>[] list, int[] a) {
        list[1].add(3);
        nodes[1].setNext(list[1]);
        a[3]++;
        list[2].add(4);
        list[2].add(6);
        nodes[2].setNext(list[2]);
        a[4]++;
        a[6]++;
        list[3].add(5);
        nodes[3].setNext(list[3]);
        a[5]++;
        list[4].add(5);
        list[4].add(6);
        nodes[4].setNext(list[4]);
        a[5]++;
        a[6]++;
        list[5].add(7);
        nodes[5].setNext(list[5]);
        a[7]++;
        list[6].add(8);
        nodes[6].setNext(list[6]);
        a[8]++;
        list[7].add(8);
        nodes[7].setNext(list[7]);
        a[8]++;
    }
}
