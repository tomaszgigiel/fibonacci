package pl.tomaszgigiel.fibonacci;

import pl.tomaszgigiel.fibonacci.utils.MatrixUtil;

public class JFibonacci {

	public static int recursive(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return recursive(n - 1) + recursive(n - 2);
	}

	public static int iterative(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int n0 = 0;
		int n1 = 1;
		int temp;
		for (int i = 2; i <= n; i++) {
			temp = n0 + n1;
			n0 = n1;
			n1 = temp;
		}
		return n1;
	}

	public static int matrix(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[][] m = new int[][] { { 1, 1 }, { 1, 0 } };
		int[][] result = MatrixUtil.power(m, n - 1);

		return result[0][0];
	}

	public static int binet(int n) {
		double sqrt5 = Math.sqrt(5);
		double phi = (1 + sqrt5) / 2;

		double a = Math.pow(phi, n);
		double b = Math.pow(-phi, -n);

		int result = (int) ((a - b) / sqrt5);
		return result;
	}

}
