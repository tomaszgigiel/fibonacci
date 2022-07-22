package pl.tomaszgigiel.fibonacci.utils;

import org.apache.commons.collections4.Equator;

public class NumberEquator implements Equator<Number> {

	@Override
	public boolean equate(Number o1, Number o2) {
		return o1.doubleValue() == o2.doubleValue();
	}

	@Override
	public int hash(Number o) {
		return o.hashCode();
	}

}
