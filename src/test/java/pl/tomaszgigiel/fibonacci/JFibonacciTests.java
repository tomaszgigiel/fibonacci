package pl.tomaszgigiel.fibonacci;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.tomaszgigiel.fibonacci.utils.Fibonacci20Const;
import pl.tomaszgigiel.fibonacci.utils.NumberEquator;

public class JFibonacciTests {

	private static NumberEquator equator = new NumberEquator();

	@Test
	void recursive() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> JFibonacci.recursive(x)).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void iterative() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> JFibonacci.iterative(x)).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void matrix() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> JFibonacci.matrix(x)).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}

	@Test
	void binet() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> JFibonacci.binet(x)).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}
}
