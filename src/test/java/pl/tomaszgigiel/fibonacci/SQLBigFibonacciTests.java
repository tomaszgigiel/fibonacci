package pl.tomaszgigiel.fibonacci;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.tomaszgigiel.fibonacci.utils.Fibonacci20Const;
import pl.tomaszgigiel.fibonacci.utils.NumberEquator;

public class SQLBigFibonacciTests {

	private static NumberEquator equator = new NumberEquator();

	@Test
	void recursive() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.recursive(BigInteger.valueOf(x))).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void iterative() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.iterative(BigInteger.valueOf(x))).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void matrix() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.matrix(BigInteger.valueOf(x))).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void binet() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.binet(BigInteger.valueOf(x))).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}
}
