package me.jianbo.ds.chapter01;

import java.util.Arrays;
import java.util.List;

/**
 * 基于分治实现最大子序列
 * @author James
 *
 */
public class MaxSubSequenceSum {

	/**
	 * 分治法实现最大序列和
	 * @param list
	 * @param left
	 * @param right
	 * @return
	 */
	private int divideAndConquer(List<Integer> list, int left, int right) {
		if (left == right) {
			return list.get(left);
		}
		// 分
		int middle = (left + right) / 2;
		int leftValue = this.divideAndConquer(list, left, middle);
		int rightValue = this.divideAndConquer(list, middle + 1, right);
		
		// 先看右边的连续最大值
		int rightMaxBorderValue = 0;
		int rightCurrentBorderValue = 0;
		for (int i = middle; i <= right; i++) {
			rightCurrentBorderValue += list.get(i);
			if (rightCurrentBorderValue > rightMaxBorderValue) {
				rightMaxBorderValue = rightCurrentBorderValue;
			}
		}
		
		// 再看左边的连续最大值
		int leftBorderMaxValue = 0;
		int leftBorderValue = 0;
		for (int i = left; i <= middle; i++) {
			leftBorderValue += list.get(i);
			if (leftBorderValue > leftBorderMaxValue) {
				leftBorderMaxValue = leftBorderValue;
			}
		}
		
		// 合并起来的最大值
		int maxBorderValue = leftBorderMaxValue + rightMaxBorderValue;
		
		// 返回3部分中最大值即为这部分的最大值
		return max(leftValue, rightValue, maxBorderValue);
	}
	
	private int max(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		}
		if (b >= a && b >= c) {
			return b;
		}
		if (c >= a && c >= b) {
			return c;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		MaxSubSequenceSum maxSubSequenceSum = new MaxSubSequenceSum();
		
		List<Integer> list = Arrays.asList(4, -3, 5, -2, -1, 6, -2);
		int maxSum = maxSubSequenceSum.divideAndConquer(list, 0, list.size() - 1);
		System.out.println(maxSum);
	}

}
