package pl.tomaszgigiel.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import pl.tomaszgigiel.fibonacci.utils.MatrixUtil;

public class JBigFibonacci {

	public static BigInteger recursive(BigInteger n) {
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return n;
		}
		return recursive(n.subtract(BigInteger.ONE)).add(recursive(n.subtract(BigInteger.TWO)));
	}

	public static BigInteger iterative(BigInteger n) {
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return n;
		}
		BigInteger n0 = BigInteger.ZERO;
		BigInteger n1 = BigInteger.ONE;
		BigInteger temp;
		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			temp = n0.add(n1);
			n0 = n1;
			n1 = temp;
		}
		return n1;
	}

	public static BigInteger matrix(BigInteger n) {
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return n;
		}
		BigInteger[][] m = new BigInteger[][] { { BigInteger.ONE, BigInteger.ONE }, { BigInteger.ONE, BigInteger.ZERO } };
		BigInteger[][] result = MatrixUtil.power(m, n.subtract(BigInteger.ONE));

		return result[0][0];
	}

	public static BigInteger binet(BigInteger n) {
		MathContext mc = new MathContext(10);
		BigDecimal sqrt5 = new BigDecimal("5").sqrt(mc);
		BigDecimal phi = (BigDecimal.ONE.add(sqrt5, mc)).divide(new BigDecimal("2"), mc);

		BigDecimal a = phi.pow(n.intValueExact(), mc);
		BigDecimal b = phi.negate().pow(n.negate().intValueExact(), mc);

		BigInteger result = (a.subtract(b, mc).divide(sqrt5, mc)).toBigInteger();
		return result;
	}

}
