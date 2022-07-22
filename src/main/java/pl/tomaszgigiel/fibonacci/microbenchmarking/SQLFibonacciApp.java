package pl.tomaszgigiel.fibonacci.microbenchmarking;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import pl.tomaszgigiel.fibonacci.SQLFibonacci;
import pl.tomaszgigiel.fibonacci.utils.Fibonacci20Const;
import pl.tomaszgigiel.fibonacci.utils.NumberEquator;

@State(Scope.Thread)
public class SQLFibonacciApp {

	private static NumberEquator equator = new NumberEquator();

	@Benchmark
	public void select() {
		List<Integer> actual = Fibonacci20Const.args.stream().map(x -> SQLFibonacci.select(x)).toList();
		CollectionUtils.isEqualCollection(Fibonacci20Const.fibonacci, actual, equator);
	}

	public static void main(String[] args) throws RunnerException {

		Options options = new OptionsBuilder() //
				.include(SQLFibonacciApp.class.getSimpleName()) //
				.threads(1) //
				.forks(1) //
				.shouldFailOnError(true) //
				.shouldDoGC(true) //
				.jvmArgs("-server") //
				.build();
		new Runner(options).run();
	}
}
