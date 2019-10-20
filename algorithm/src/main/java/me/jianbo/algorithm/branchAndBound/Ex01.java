package me.jianbo.algorithm.branchAndBound;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 装载问题
 */
public class Ex01 {
    public static void main(String[] args) {
        // 集装箱数量
        int containerQty = 3;
        // 集装箱重量
        int[] containersWeight = {8, 6, 2};
        // 轮船负载
        int loadWeight = 12;

        int bestWeight = fifoMaxLoading(containerQty, containersWeight, loadWeight);
        System.out.println(bestWeight);
    }

    private static int fifoMaxLoading(int containerQty, int[] containersWeight, int loadWeight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(-1);

        // 当前层数
        int i = 1;
        // 当前扩展结点的重量
        int cw = 0;
        // 已知的最优解
        int bestWeight = 0;
        while (!queue.isEmpty()) {
            // 展开该层结点

            // 先展开左边, 左边表示选中, 然后放入到队列中
            if (cw + containersWeight[i - 1] < loadWeight) { // 该条件表示分支限界的 [约束函数]
                bestWeight = saveQueue(queue, cw + containersWeight[i- 1], bestWeight, i, containerQty);
            }
            // 再展开右边, 右边表示未选中, 即不装, 然后放入到队列中
            bestWeight = saveQueue(queue, cw, bestWeight, i, containerQty);
            cw = queue.poll();
            // 如果head = -1, 表示当前层级已经展开完
            if (cw == -1) {
                if (queue.isEmpty()) {
                    return bestWeight;
                }
                queue.offer(-1);
                cw = queue.poll();
                i = i + 1;
            }
        }
        return bestWeight;
    }

    private static int saveQueue(Queue<Integer> queue, int currentWeight, int bestWeight, int i, int n) {
        if (i == n) {
            if (currentWeight > bestWeight) {
                bestWeight = currentWeight;
            }
        } else {
            queue.offer(currentWeight);
        }
        return bestWeight;
    }
}
