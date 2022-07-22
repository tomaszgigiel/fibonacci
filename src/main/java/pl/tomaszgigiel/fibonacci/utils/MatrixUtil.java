package pl.tomaszgigiel.fibonacci.utils;

import java.math.BigInteger;

public class MatrixUtil {

	public static int[][] multiply(int a[][], int b[][]) {
		int x = a[0][0] * (b[0][0]) + (a[0][1] * (b[1][0]));
		int y = a[0][0] * (b[0][1]) + (a[0][1] * (b[1][1]));
		int z = a[1][0] * (b[0][0]) + (a[1][1] * (b[1][0]));
		int w = a[1][0] * (b[0][1]) + (a[1][1] * (b[1][1]));

		int[][] result = new int[][] { { x, y }, { z, w } };

		return result;
	}

	public static BigInteger[][] multiply(BigInteger a[][], BigInteger b[][]) {
		BigInteger x = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
		BigInteger y = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
		BigInteger z = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
		BigInteger w = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));

		BigInteger[][] result = new BigInteger[][] { { x, y }, { z, w } };

		return result;
	}

	public static int[][] power(int[][] a, int n) {
		int[][] result = a;
		if (n == 0) {
			throw new java.lang.UnsupportedOperationException("TODO");
		}
		if (n == 1) {
			return result;
		}

		int quotient = n / 2;
		int remainder = n % 2;

		result = power(a, quotient);
		result = multiply(result, result);
		if (remainder == 1) {
			result = multiply(result, a);
		}

		return result;
	}

	public static BigInteger[][] power(BigInteger[][] a, BigInteger n) {
		BigInteger[][] result = a;
		if (n.equals(BigInteger.ZERO)) {
			throw new java.lang.UnsupportedOperationException("TODO");
		}
		if (n.equals(BigInteger.ONE)) {
			return result;
		}

		BigInteger[] divideAndRemainder = n.divideAndRemainder(BigInteger.TWO);
		result = power(a, divideAndRemainder[0]);
		result = multiply(result, result);
		if (divideAndRemainder[1].equals(BigInteger.ONE)) {
			result = multiply(result, a);
		}

		return result;
	}
}
