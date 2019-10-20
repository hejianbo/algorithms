package me.jianbo.algorithm.branchAndBound;

import java.util.LinkedList;
import java.util.Queue;

public class Ex02 {
    public static void main(String[] args) {
        // 集装箱数量
        int containerQty = 3;
        // 集装箱重量
        int[] containersWeight = {8, 6, 2};
        // 轮船负载
        int loadWeight = 12;

        int bestWeight = improvedFIFOMaxLoading(containerQty, containersWeight, loadWeight);

        System.out.println(bestWeight);
    }

    private static int improvedFIFOMaxLoading(int containerQty, int[] containersWeight, int loadWeight) {
        Queue<Integer> queue = new LinkedList<>();
        // 先添加一个哨兵
        queue.offer(-1);
        int i = 1;
        int bestWeight = 0;
        int currentWeight = 0;

        while (!queue.isEmpty()) {
            // 先通过约束函数判断
            int leftWeight = currentWeight + containersWeight[i - 1];
            if (leftWeight < loadWeight) {
                if (leftWeight > bestWeight) {
                    bestWeight = leftWeight;
                }
                if (i < containerQty) {
                    queue.offer(leftWeight);
                }
            }
            // 限界函数
            if (currentWeight + getLeftWeight(i, containersWeight) > bestWeight && i < containerQty) {
                queue.offer(currentWeight);
            }

            currentWeight = queue.poll();
            if (currentWeight == -1) {
                if (queue.isEmpty()) {
                    return bestWeight;
                }
                currentWeight = queue.poll();
                queue.offer(-1);
                i = i + 1;
            }
        }

        return 0;
    }

    private static int getLeftWeight(int start, int[] containersWeight) {
        int sum = 0;
        for (int i = start; i < containersWeight.length; i++) {
            sum += containersWeight[i];
        }
        return sum;
    }
}
