package cn.geliang.dp;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int M = 5000; // 代表无穷
        int[][] weight1 = {
                {0,4,M,2,M},
                {4,0,4,1,M},
                {M,4,0,1,3},
                {2,1,1,0,7},
                {M,M,3,7,0}
        };
        int start = 0;
        int[] shortPath = dijkstra(weight1, 0);
        for (int i = 0; i < weight1.length; i++) {
            System.out.print(shortPath[i] + " ");
        }
    }

    private static int[] dijkstra(int[][] weight1, int start) {
        int n = weight1.length;
        boolean[] isVisit = new boolean[n];
        Arrays.fill(isVisit, false);

        // 到i点的最短路径
        int[] shortPath = new int[n];
        // 路径打印pathPring start->i点
        String[] pathPrint = new String[n];

        for (int i = 0; i < n; ++i) {
            shortPath[i] = weight1[start][i];
            if (i == start) {
                pathPrint[i] = String.valueOf(i);
            } else {
                pathPrint[i] = start +"-->" + i;
            }
        }


        // 遍历处理start外的其他节点
        isVisit[start] = true;
        for (int i = 1; i < n; ++i) {
            int next = -1; // 下一个标记点索引
            int minDis = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!isVisit[j] && shortPath[j] < minDis) {
                    // 更新，寻找未访问过的最近节点
                    minDis = shortPath[j];
                    next = j;
                }
            }

            // 更新最短路径
            isVisit[next] = true;
            shortPath[next] = minDis;

            for (int k = 0; k < n; k++) {
                if (!isVisit[k] && shortPath[k] > shortPath[next] + weight1[next][k]) {
                    shortPath[k] =  shortPath[next] + weight1[next][k];
                    pathPrint[i] = pathPrint[next] + "-->" + i;
                }
            }
        }
        return shortPath;

    }
}
