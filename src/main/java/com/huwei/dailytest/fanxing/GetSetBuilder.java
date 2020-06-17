package com.huwei.dailytest.fanxing;

import com.fasterxml.jackson.databind.util.Named;
import org.apache.commons.collections4.Get;

public class GetSetBuilder {

	public static <T> GetSet<T> of(Set<T> set) {
		return new GetSet<T>() {
			@Override
			public void set(T value) {
				set.set(value);
			}
		};
	}


	public static <T> GetSet<T> of(T value) {
		return new GetterSetter<>(value);
	}


}
