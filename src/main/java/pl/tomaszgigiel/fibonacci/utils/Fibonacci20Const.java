package pl.tomaszgigiel.fibonacci.utils;

import java.util.List;
import java.util.stream.IntStream;

public class Fibonacci20Const {
	public static final List<Integer> fibonacci = List.of(//
			0, 1, 1, 2, 3, 5, 8, 13, 21, 34, // 0 - 9
			55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181); // 10 - 19

	public static final List<Integer> args = IntStream.range(0, Fibonacci20Const.fibonacci.size()).boxed().toList();
}
