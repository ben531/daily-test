package com.huwei.dailytest.fanxing;

public class GetterSetter<T> implements GetSet<T> {

	private T value;

	public GetterSetter() {
	}

	public GetterSetter(T value) {
		this.value = value;
	}


	@Override
	public void set(T value) {
		this.value = value;
	}

}