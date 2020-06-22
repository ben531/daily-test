package com.huwei.dailytest.fanxing;

public class GetSetBuilder {

	public static <T> GetSet<T> of(MySet<T> mySet) {
		return new GetSet<T>() {
			@Override
			public void set(T value) {
				mySet.set(value);
			}
		};
	}


}
