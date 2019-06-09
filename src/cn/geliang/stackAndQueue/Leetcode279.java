package cn.geliang.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode279 {
    // 20190605
    public int numSquares(int n) {
        Queue<Num2NumStep> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n+1];
        Arrays.fill(isVisited, false);
        queue.add(new Num2NumStep(n, 0));
        while (queue.size() != 0) {
            Num2NumStep numStep = queue.poll();
            int num = numStep.num;
            int step = numStep.step;
            for (int i = 1; ; i++) {
                int nextNum = num - i*i;
                if (nextNum < 0) {
                    break;
                }
                if (nextNum == 0) {
                    return step + 1;
                }
                if (isVisited[nextNum] == false) {
                    isVisited[nextNum] = true;
                    queue.add(new Num2NumStep(nextNum, step+1));
                }
            }
        }
        return -1;
    }

    // 处理n到num需要最少走step步
    private class Num2NumStep {
        int num;
        int step;

        public Num2NumStep(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }
}
