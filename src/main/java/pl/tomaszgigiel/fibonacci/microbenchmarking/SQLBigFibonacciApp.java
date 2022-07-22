package pl.tomaszgigiel.fibonacci.microbenchmarking;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import pl.tomaszgigiel.fibonacci.SQLBigFibonacci;
import pl.tomaszgigiel.fibonacci.utils.Fibonacci20Const;
import pl.tomaszgigiel.fibonacci.utils.NumberEquator;

@State(Scope.Thread)
public class SQLBigFibonacciApp {

	private static NumberEquator equator = new NumberEquator();

	@Benchmark
	public void recursive() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.recursive(BigInteger.valueOf(x))).toList();
		CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator);
	}

	@Benchmark
	public void iterative() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.iterative(BigInteger.valueOf(x))).toList();
		CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator);
	}

	@Benchmark
	public void matrix() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.matrix(BigInteger.valueOf(x))).toList();
		CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator);
	}

	@Benchmark
	public void binet() {
		List<BigInteger> actual = Fibonacci20Const.args.stream().map(x -> SQLBigFibonacci.binet(BigInteger.valueOf(x))).toList();
		CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator);
	}

	public static void main(String[] args) throws RunnerException {

		Options options = new OptionsBuilder() //
				.include(SQLBigFibonacciApp.class.getSimpleName()) //
				.threads(1) //
				.forks(1) //
				.shouldFailOnError(true) //
				.shouldDoGC(true) //
				.jvmArgs("-server") //
				.build();
		new Runner(options).run();
	}
}
