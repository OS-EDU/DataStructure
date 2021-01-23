package com.quake.graph;

import java.util.ArrayList;

/**
 * @author AKA二夕
 * @create 2021-01-23 20:10
 */
public class Graph {
    private ArrayList<String> vertexList;// 存储顶点集合
    private int[][] edges;// 存储图对应的邻接矩阵
    private int numOfEdges;// 表示边的数目

    public static void main(String[] args) {

    }

    // 构造器
    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
}
