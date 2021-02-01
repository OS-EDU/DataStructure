package com.quake.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author AKA二夕
 * @create 2021-01-23 20:10
 */
public class Graph {
    private ArrayList<String> vertexList;// 存储顶点集合
    private int[][] edges;// 存储图对应的邻接矩阵
    private int numOfEdges;// 表示边的数目
    private boolean[] isVisited;// 定义一个数组boolean 记录某个结点是否被访问

    public static void main(String[] args) {
        int n = 8;//节点个数
        String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //显示邻接矩阵
        graph.showGraph();

        // 测试dfs()
        System.out.println("测试深度优先遍历");
        graph.dfs();

        System.out.println();// 换行

        //bfs遍历
        System.out.println("广度优先遍历");
        graph.bfs();
    }

    // 构造器
    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    // 返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 显示对应的矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    // 返回 v1 和 v2 的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 返回结点 i（下标）对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 添加边的方法
     *
     * @param v1     表示点的下标即第几个顶点
     * @param v2     表示第二个顶点的下标
     * @param weight 表示权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        // 保证来回路径的权值一样
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;// 边的条数 +1
    }

    /**
     * 得到第一个邻接结点的下标
     *
     * @param index 当前结点的索引
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根绝前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     *
     * @param isVisited 用于标记结点是否被访问
     * @param i         第一次就是0
     */
    private void dfs(boolean[] isVisited, int i) {
        // 首先访问该结点
        System.out.print(getValueByIndex(i) + "->");
        // 将结点设置为已经访问
        isVisited[i] = true;
        // 得到下一个邻接结点的坐标
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    // 重载dfs()，遍历所有的结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        // 遍历所有的结点，并进行dfs【回溯】
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u;// 表示队列的头结点对应的下标
        int w;// 邻接结点w
        // 队列，用于记录结点的访问顺序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "->");
        // 标记为已访问
        isVisited[i] = true;
        // 将结点加入到队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            // 取出队列头结点的下标
            u = (Integer) queue.removeFirst();
            // 得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {
                // 是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    // 标记为已经访问
                    isVisited[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前序点，为w后面的下一个邻接点
                w = getNextNeighbor(u, w);
            }
        }
    }

    // 重载bfs，遍历所有的结点，都进行广度优先遍历
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

}
