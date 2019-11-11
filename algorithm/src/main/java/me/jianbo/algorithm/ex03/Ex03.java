package me.jianbo.algorithm.ex03;

public class Ex03 {
	public static void main(String[] args) {
		// 维数
		int n = 3;
		int[] result = new int[n * n + 1];
		int[] leftValues = new int[n + 1];
		boolean flag = run(result, leftValues, 1, n);
		if (flag) {
			for (int i = 1; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}
	
	private static boolean run(int[] result, int[] leftValues, int m, int n) {
		if (m == result.length) {
			return true;
		}
		for (int i = 1; i < leftValues.length && leftValues[i] == 0; i++) {
			result[m] = 1;
			if (m % n == 0 && isMatch(result, m)) {
				if (run(result, leftValues, m + 1, n)) {
					return true;
				}
			}
			result[m] = 0;			
		}
		return false;
	}
	
	private static int getLineTotal(int n) {
		return (1 + n * n) * n / 2;
	}
	private static boolean isMatch(int[] result, int m) {
		boolean row = result[m - 2] + result[m - 1] + result [m] == getLineTotal(result.length - 1);
		if (!row) {
			return false;
		}
		return true;

	}
}
