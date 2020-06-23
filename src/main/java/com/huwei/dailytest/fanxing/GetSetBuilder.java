package com.huwei.dailytest.fanxing;

import lombok.Data;

public class GetSetBuilder {

	public static <T> GetSet<T> of(Get<T> get, MySet<T> mySet) {
		return new GetSet<T>() {
            @Override
            public T get() {
                return get.get();
            }
			@Override
			public void set(T value) {
				mySet.set(value);
			}
		};
	}





}
