package pl.tomaszgigiel.fibonacci;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.tomaszgigiel.fibonacci.utils.Fibonacci20Const;
import pl.tomaszgigiel.fibonacci.utils.NumberEquator;

public class SQLFibonacciTests {

	private static NumberEquator equator = new NumberEquator();

	@Test
	void select() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> SQLFibonacci.select(x)).toList();
		Assertions.assertTrue(CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator));
	}
}
