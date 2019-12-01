package me.jianbo.algorithm.bjdx.chapter05;

public class 投资问题 {
	public static void main(String[] args) {
		int money = 5;
		int projects = 4;
		// 投资5万元钱，4个项目
		// 效益函数[投资金额x][项目i]
		int[][] benefitTable = {
			{0, 0, 0, 0},
			{11, 0, 2, 20},
			{12, 5, 10, 21},
			{13, 10, 30, 22},
			{14, 15, 32, 23},
			{15, 20, 40, 24}
		};
		
		// 备忘录
		int[][] memos = new int[money][projects];
		// 项目投0元钱的初始值都为0
		for (int i = 0; i < projects; i++) {
			memos[0][i] = 0;
		}
		// 只有1个项目时的初始值
		for (int i = 0; i < money; i++) {
			memos[i][0] = benefitTable[i][0];
		}
		
		for (int i = 1; i < projects; i++) {
			for (int j = 1; j < money; j++) {
				int maxBenefit = 0;
				for (int m = 0; m <= j; m++) {
					int currentBenefit = benefitTable[m][i - 1];
					int leftBenefit = memos[j - m][i - 1];
					int totalBenefit = currentBenefit + leftBenefit;
					if (totalBenefit > maxBenefit) {
						maxBenefit = totalBenefit;
					}
				}
				memos[j][i] = maxBenefit;
			}
		}
		
		for (int i = 0; i < money; i++) {
			for (int j = 0; j < projects; j++) {
				System.out.print(" " + memos[i][j]);
			}
			System.out.println();
		}
	}
}
